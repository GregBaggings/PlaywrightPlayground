package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.fail;

public class YourCartPage {

    private final Locator selectedProductList;
    private final Locator checkoutButton;

    public YourCartPage(Page page) {
        this.selectedProductList = page.locator(".cart_item");
        this.checkoutButton = page.locator("#checkout");
    }

    @Step("Proceed to checkout from the cart")
    public void goToCheckout() {
        if (selectedProductList.all().isEmpty()) {
            fail("Shopping cart was empty");
        } else {
            checkoutButton.click();
        }
    }

}
