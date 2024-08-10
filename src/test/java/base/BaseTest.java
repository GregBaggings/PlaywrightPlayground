package base;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testdata.TestData;
import testdata.TestDataHandler;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

import static util.ExecutionDateHandler.getExecutionDate;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    protected TestData testData = new TestData();
    protected Page page;

    @BeforeEach
    public void prepareTestData() {
        new TestDataHandler().prepareTestData(testData);
        LOGGER.info("Prepared data before the actual test: {}", testData);
    }

    @BeforeEach
    public void setupPlaywright() {
        page = PlaywrightFactory.getPage();
    }

    @AfterEach
    public void cleanUpTest() {
        LOGGER.debug("Take screenshot and destroy the playwright instance");
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/" + getExecutionDate() + "_screenshot.png")).setFullPage(true));
        Allure.addAttachment("screenshot", new ByteArrayInputStream(screenshot));
        PlaywrightFactory.close();
    }

}
