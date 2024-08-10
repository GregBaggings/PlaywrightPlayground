package poc.checkout;

import base.BaseTest;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pages.*;
import testdata.JsonArgumentsProvider;
import testdata.TestData;
import util.TestCaseKeys;

import static constants.Constants.EXPECTED_SUCCESS_MESSAGE;

@UsePlaywright
public class CheckoutWithDataFromFileExampleTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ProductListPage productListPage = new ProductListPage();
    private final YourCartPage yourCartPage = new YourCartPage();
    private final PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    private final FeedbackPage feedbackPage = new FeedbackPage();

    @DisplayName("Checkout flow with different users")
    @ParameterizedTest(name = "Checkout with user: {0}")
    @ArgumentsSource(JsonArgumentsProvider.class)
    @TestCaseKeys({"visualUser", "performanceGlitchUser"})
    public void checkoutTest(TestData dataFromFile) {
        testData.setUsername(dataFromFile.getUsername());
        testData.setPassword(dataFromFile.getPassword());

        loginPage.login(testData.getUsername(), testData.getPassword());
        productListPage.selectProduct();
        productListPage.openShoppingCart();
        yourCartPage.goToCheckout();
        personalDetailsPage.fillCheckoutDetails(
                testData.getFirstName(),
                testData.getLastName(),
                testData.getPlanet());
        personalDetailsPage.continueToFinishCheckout();
        productListPage.finishCheckout();
        Assertions.assertEquals(feedbackPage.getFeedbackText(), EXPECTED_SUCCESS_MESSAGE);
    }

}
