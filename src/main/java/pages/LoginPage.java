package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import io.qameta.allure.Step;

import static constants.Constants.SUT_URL;

public class LoginPage {

    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Page page;

    public LoginPage() {
        page = PlaywrightFactory.getPage();
        this.userNameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    @Step("Login with user: {0}")
    public void login(String userName, String password) {
        page.navigate(SUT_URL);
        userNameInput.fill(userName);
        passwordInput.fill(password);
        loginButton.click();
    }

}
