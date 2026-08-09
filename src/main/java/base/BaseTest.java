package base;

import config.ConfigManager;
import driver.AppiumServerManager;
import driver.DriverManager;
import driver.LocalDriverFactory;
import driver.SauceDriverFactory;
import io.cucumber.java.BeforeAll;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeAll
    public void beforeAll() throws MalformedURLException {
        AppiumServerManager.startServer();
        initializeDriver();
    }

    public void afterAll(){
        quitDriver();
    }

    protected void initializeDriver() throws MalformedURLException {
        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            new LocalDriverFactory().createDriver();
        } else {
            new SauceDriverFactory().createDriver();
        }
    }

    protected void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
