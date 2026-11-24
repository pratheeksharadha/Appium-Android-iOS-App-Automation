
package hooks;

import config.ConfigManager;
import driver.AppiumServerManager;
import driver.DriverFactory;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

import java.net.MalformedURLException;

public class BaseHooks {

    private static final Logger logger =
            LoggerUtils.getLogger(BaseHooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("=============== Cucumber Execution Started ===============");

        if ("local".equalsIgnoreCase(ConfigManager.getExecution())) {
            AppiumServerManager.startServer();
        }
    }

    @Before
    public void beforeScenario() throws MalformedURLException {

        logger.info("=============== Scenario Started ===============");
        logger.info("Execution   : {}", ConfigManager.getExecution());
        logger.info("Platform    : {}", ConfigManager.getPlatformName());
        logger.info("Environment : {}", ConfigManager.getEnvironment());
        logger.info("Device      : {}", ConfigManager.getDeviceName());

        AppiumDriver driver = DriverFactory.createDriver();

        DriverManager.setDriver(driver);

        logger.info("Scenario driver initialized successfully.");
    }

    @After
    public void afterScenario() {

        try {
            AppiumDriver driver = DriverManager.getDriver();

            if (driver != null) {
                logger.info("Closing scenario driver.");
                driver.quit();
                logger.info("Scenario driver closed successfully.");
            }

        } catch (Exception e) {
            logger.error("Error while closing scenario driver.", e);

        } finally {
            DriverManager.unload();
            logger.info("Scenario driver removed from ThreadLocal.");
        }

        logger.info("=============== Scenario Finished ===============");
    }

    @AfterAll
    public static void afterAll() {

        if ("local".equalsIgnoreCase(ConfigManager.getExecution())) {
            AppiumServerManager.stopServer();
        }

        logger.info("=============== Cucumber Execution Finished ===============");
    }
}
