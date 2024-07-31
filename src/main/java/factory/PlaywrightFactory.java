package factory;

import com.microsoft.playwright.*;

import static constants.Constants.CHROME;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;

    public Page getPage(String browserType) {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        playwright = Playwright.create();

        if (CHROME.equals(browserType)) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        } else {
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        }

        browserContext = browser.newContext();

        return browserContext.newPage();
    }

}
