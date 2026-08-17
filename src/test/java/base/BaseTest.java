package base;

import config.ConfigManager;
import driver.AppiumServerManager;
import driver.DriverManager;
import driver.LocalDriverFactory;
import driver.SauceDriverFactory;
import io.cucumber.java.AfterAll;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.LoggerUtils;

import java.net.MalformedURLException;

public class BaseTest {

    private static final Logger logger =  LoggerUtils.getLogger(BaseTest.class);

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        logger.info("===============TestSuite Started=============");
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            AppiumServerManager.startServer();
        }
    }

    @AfterSuite
    public void afterSuite(){

        logger.info("===== Test Suite Finished =====");
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            AppiumServerManager.stopServer();
        }

    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        logger.info("Starting test setup");
        logger.info("Execution      : {}", ConfigManager.getExecution());
        logger.info("Platform       : {}", ConfigManager.getPlatform());
        logger.info("Environment    : {}", ConfigManager.getEnvironment());
        logger.info("Device Name    : {}", ConfigManager.getDeviceName());
        logger.info("Application    : {}", ConfigManager.getAppPath());
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            logger.info("Appium Server : {}", ConfigManager.getAppiumUrl());
        } else {
            logger.info("Sauce URL     : {}", ConfigManager.getSauceUrl());
        }

        initializeDriver();

        logger.info("Driver initialized successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult results){

        if(results.getStatus() == ITestResult.FAILURE){
            logger.error("Test Failed : " + results.getName());
            logger.error(results.getThrowable());
        }
        logger.info("Closing Driver");
        quitDriver();
    }

    protected void initializeDriver() throws MalformedURLException {
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            DriverManager.setDriver(new LocalDriverFactory().createDriver());
        } else if (ConfigManager.getExecution().equalsIgnoreCase("sauce")) {
            DriverManager.setDriver(new SauceDriverFactory().createDriver());
        }

    }

    protected void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            logger.info("Driver closed successfully.");
            DriverManager.unload();
            logger.info("Driver removed from ThreadLocal.");
        }

    }
}
