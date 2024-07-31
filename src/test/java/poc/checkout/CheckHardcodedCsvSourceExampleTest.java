package poc.checkout;

import base.BaseTest;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;

import java.util.Map;

import static constants.Constants.*;
import static testdata.TestDataHandler.prepareTestData;

@UsePlaywright
public class CheckHardcodedCsvSourceExampleTest extends BaseTest {

    private Map<String, String> testData;

    private final LoginPage loginPage = new LoginPage();
    private final ProductListPage productListPage = new ProductListPage();
    private final YourCartPage yourCartPage = new YourCartPage();
    private final PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    private final FeedbackPage feedbackPage = new FeedbackPage();

    @BeforeEach
    public void setTestData() {
        testData = prepareTestData();
    }

    @DisplayName("Checkout flow with different users")
    @ParameterizedTest(name = "Checkout with user: {0}")
    @CsvSource({"standard_user,secret_sauce"})
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
