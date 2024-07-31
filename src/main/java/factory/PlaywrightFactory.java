package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    /**
     * To enable parallel execution each Playwright object needs to have a separate instance created in a ThreadLocal variable
     * The chain is the following Playwright->Browser->BrowserContext->Page
     **/
    private static final ThreadLocal<Playwright> PLAYWRIGHT_INSTANCE = ThreadLocal.withInitial(Playwright::create);
    private static final ThreadLocal<Browser> BROWSER_INSTANCE = ThreadLocal.withInitial(() -> {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        return PLAYWRIGHT_INSTANCE.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
    });
    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_INSTANCE = ThreadLocal.withInitial(() -> BROWSER_INSTANCE.get().newContext());
    private static final ThreadLocal<Page> PAGE_INSTANCE = ThreadLocal.withInitial(() -> BROWSER_CONTEXT_INSTANCE.get().newPage());

    public static Page getPage() {
        return PAGE_INSTANCE.get();
    }

    public static void close() {
        Page page = PAGE_INSTANCE.get();
        if (page != null) {
            page.close();
            PAGE_INSTANCE.remove();
        }

        BrowserContext browserContext = BROWSER_CONTEXT_INSTANCE.get();
        if (browserContext != null) {
            browserContext.close();
            BROWSER_CONTEXT_INSTANCE.remove();
        }

        Browser browser = BROWSER_INSTANCE.get();
        if (browser != null) {
            browser.close();
            BROWSER_INSTANCE.remove();
        }

        Playwright playwright = PLAYWRIGHT_INSTANCE.get();
        if (playwright != null) {
            playwright.close();
            PLAYWRIGHT_INSTANCE.remove();
        }
    }

}
