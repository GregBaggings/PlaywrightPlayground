package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import io.qameta.allure.Step;

public class ProductListPage {

    private final Locator addToCartButton;
    private final Locator shoppingCartButton;
    private final Locator finishCheckoutButton;

    public ProductListPage() {
        Page page = PlaywrightFactory.getPage();
        this.addToCartButton = page.locator("#add-to-cart-sauce-labs-backpack");
        this.shoppingCartButton = page.locator(".shopping_cart_badge");
        this.finishCheckoutButton = page.locator("#finish");
    }

    @Step("Select product")
    public void selectProduct() {
        addToCartButton.click();
    }

    @Step("Open the shopping cart")
    public void openShoppingCart() {
        shoppingCartButton.click();
    }

    @Step("Finish the product browsing")
    public void finishCheckout() {
        finishCheckoutButton.click();
    }

}
