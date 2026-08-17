package driver;

import config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

import java.net.MalformedURLException;
import java.net.URI;

public class IOSDriverFactory {

    private static final Logger logger = LoggerUtils.getLogger(IOSDriverFactory.class);
    static IOSDriver driver;
    public static IOSDriver createIOSDriver() throws MalformedURLException {
        logger.info("Creating IOS Driver Created");

        CapabilityManager capabilityManager = new CapabilityManager();
        XCUITestOptions iosOptions = (XCUITestOptions) capabilityManager.getOptions();

        if (ConfigManager.getExecution().equalsIgnoreCase("local")) {
            driver = new IOSDriver(URI.create(ConfigManager.getAppiumUrl()).toURL(), iosOptions);
            System.out.println(driver.getCapabilities());
        } else if (ConfigManager.getExecution().equalsIgnoreCase("sauce"))
        {
            driver = new IOSDriver(URI.create(ConfigManager.getSauceUrl()).toURL(), iosOptions);
            System.out.println(driver.getCapabilities());
        }

        DriverManager.setDriver(driver);
        logger.info("IOS Driver Created Successfully");
        return  driver;



    }
}
