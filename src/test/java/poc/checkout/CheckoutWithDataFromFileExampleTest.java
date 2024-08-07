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
import testdata.TestData;
import util.TestCaseKeys;

import java.util.Map;

import static constants.Constants.*;

@UsePlaywright
public class CheckoutWithDataFromFileExampleTest extends BaseTest {

    private Map<String, String> testData;

    private final LoginPage loginPage = new LoginPage();
    private final ProductListPage productListPage = new ProductListPage();
    private final YourCartPage yourCartPage = new YourCartPage();
    private final PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    private final FeedbackPage feedbackPage = new FeedbackPage();

    @BeforeEach
    public void setTestData() {
        testData = testDataHandler.prepareTestData();
    }

    @DisplayName("Checkout flow with different users")
    @ParameterizedTest(name = "Checkout with user: {0}")
    @ArgumentsSource(JsonArgumentsProvider.class)
    @TestCaseKeys({"visualUser", "performanceGlitchUser"})
    public void checkoutTest(TestData data) {
        loginPage.login(data.getUsername(), data.getPassword());
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
