package poc.checkout;

import base.BaseTest;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;

import java.util.Map;

import static constants.Constants.*;
import static util.TestDataHandler.prepareTestData;

@UsePlaywright
public class DemoTest extends BaseTest {

    private Map<String, String> testData;

    private LoginPage loginPage;
    private ProductListPage productListPage;
    private YourCartPage yourCartPage;
    private PersonalDetailsPage personalDetailsPage;
    private FeedbackPage feedbackPage;

    @BeforeEach
    public void setTestData() {
        testData = prepareTestData(page);

        loginPage = new LoginPage(page);
        productListPage = new ProductListPage(page);
        yourCartPage = new YourCartPage(page);
        personalDetailsPage = new PersonalDetailsPage(page);
        feedbackPage = new FeedbackPage(page);
    }

    @DisplayName("Checkout flow with different users")
    @ParameterizedTest(name = "Checkout with user: {0}")
    @CsvSource({"standard_user,secret_sauce"})
    public void checkoutTest(String username, String password) {
        page.navigate(SUT_URL);

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
