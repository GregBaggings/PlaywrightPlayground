package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FeedbackPage {

    private final Locator feedbackText;

    public FeedbackPage(Page page) {
        this.feedbackText = page.locator(".complete-header");
    }

    public String getFeedbackText() {
        return feedbackText.textContent();
    }

}
