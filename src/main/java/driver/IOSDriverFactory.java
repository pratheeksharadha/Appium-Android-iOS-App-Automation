package driver;

import config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URI;

public class IOSDriverFactory {

    static IOSDriver driver;
    public static IOSDriver createIOSDriver() throws MalformedURLException {
        //System.out.println("iOS driver is created here");
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
        return  driver;



    }
}
