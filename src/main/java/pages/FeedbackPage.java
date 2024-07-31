package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;

public class FeedbackPage {

    private final Locator feedbackText;

    public FeedbackPage() {
        Page page = PlaywrightFactory.getPage();
        this.feedbackText = page.locator(".complete-header");
    }

    public String getFeedbackText() {
        return feedbackText.textContent();
    }

}
