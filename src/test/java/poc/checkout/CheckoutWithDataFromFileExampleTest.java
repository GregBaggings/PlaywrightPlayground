package poc.checkout;

import base.BaseTest;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pages.*;
import testdata.JsonArgumentsProvider;

import java.util.Map;

import static constants.Constants.*;
import static util.TestDataHandler.prepareTestData;

@UsePlaywright
public class CheckoutWithDataFromFileExampleTest extends BaseTest {

    private Map<String, String> testData;

    private LoginPage loginPage;
    private ProductListPage productListPage;
    private YourCartPage yourCartPage;
    private PersonalDetailsPage personalDetailsPage;
    private FeedbackPage feedbackPage;

    @BeforeEach
    public void setTestData() {
        testData = prepareTestData();

        loginPage = new LoginPage();
        productListPage = new ProductListPage();
        yourCartPage = new YourCartPage();
        personalDetailsPage = new PersonalDetailsPage();
        feedbackPage = new FeedbackPage();
    }

    @DisplayName("Checkout flow with different users")
    @ParameterizedTest(name = "Checkout with user: {0}")
    @ArgumentsSource(JsonArgumentsProvider.class)
    public void checkoutTest(String username, String password) {
        loginPage.login(username, password);
        productListPage.selectProduct();
        productListPage.openShoppingCart();
        yourCartPage.goToCheckout();
        personalDetailsPage.fillCheckoutDetails(
                testData.get(FIRST_NAME),
                testData.get(LAST_NAME),
                testData.get(PLANET));
        personalDetailsPage.continueToFinishCheckout();
        productListPage.finishCheckout();
        Assertions.assertEquals(feedbackPage.getFeedbackText(), EXPECTED_SUCCESS_MESSAGE);
    }

}
