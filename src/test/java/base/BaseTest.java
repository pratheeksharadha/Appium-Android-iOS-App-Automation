package base;

import config.ConfigManager;
import driver.AppiumServerManager;
import driver.DriverManager;
import driver.LocalDriverFactory;
import driver.SauceDriverFactory;
import io.cucumber.java.AfterAll;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            AppiumServerManager.startServer();
        }
    }

    @AfterSuite
    public void afterSuite(){

        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            AppiumServerManager.stopServer();
        }

    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        initializeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
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
            DriverManager.unload();
        }

    }
}
