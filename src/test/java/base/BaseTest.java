
package base;

import config.ConfigManager;
import driver.AppiumServerManager;
import driver.DriverFactory;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.LoggerUtils;

import java.net.MalformedURLException;

public class BaseTest {

    private static final Logger logger =
            LoggerUtils.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        logger.info("=============== Test Suite Started ===============");

        if ("local".equalsIgnoreCase(ConfigManager.getExecution())) {
            AppiumServerManager.startServer();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {

        logger.info("================ Test Suite Finished ================");

        if ("local".equalsIgnoreCase(ConfigManager.getExecution())) {
            AppiumServerManager.stopServer();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {

        logger.info("Starting test setup");
        logger.info("Execution   : {}", ConfigManager.getExecution());
        logger.info("Platform    : {}", ConfigManager.getPlatformName());
        logger.info("Environment : {}", ConfigManager.getEnvironment());
        logger.info("Device      : {}", ConfigManager.getDeviceName());
        logger.info("Application : {}", ConfigManager.getAppPath());

        if ("local".equalsIgnoreCase(ConfigManager.getExecution())) {
            logger.info("Appium URL  : {}", ConfigManager.getAppiumUrl());
        } else {
            logger.info("Sauce URL   : {}", ConfigManager.getSauceUrl());
        }

        AppiumDriver driver = DriverFactory.createDriver();

        DriverManager.setDriver(driver);

        logger.info("Driver initialized successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.error("Test failed: {}", result.getName());
                logger.error("Failure details:", result.getThrowable());
            }
        } finally {
            quitDriver();
        }
    }

    protected void quitDriver() {

        AppiumDriver driver = DriverManager.getDriver();

        if (driver == null) {
            logger.warn("No driver found for the current thread.");
            return;
        }

        try {
            logger.info("Closing driver");
            driver.quit();
            logger.info("Driver closed successfully");
        } catch (Exception e) {
            logger.error("Error while closing driver", e);
        } finally {
            DriverManager.unload();
            logger.info("Driver removed from ThreadLocal");
        }
    }
}
