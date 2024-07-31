package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static constants.Constants.PASSWORD;
import static constants.Constants.USER;

public class LoginPage {

    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.userNameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    @Step("Login with user: {0}")
    public void login(String userName, String password) {
        userNameInput.fill(userName);
        passwordInput.fill(password);
        loginButton.click();
    }

}
