package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class PersonalDetailsPage {

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator zipPostalInput;
    private final Locator continueButton;

    public PersonalDetailsPage(Page page) {
        this.firstNameInput = page.locator("#first-name");
        this.lastNameInput = page.locator("#last-name");
        this.zipPostalInput = page.locator("#postal-code");
        this.continueButton = page.locator("#continue");
    }

    @Step("Fill the checkout form")
    public void fillCheckoutDetails(String firstName, String lastName, String planet) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        zipPostalInput.fill(planet);
    }

    @Step("Continue to finish the checkout")
    public void continueToFinishCheckout() {
        continueButton.click();
    }

}
