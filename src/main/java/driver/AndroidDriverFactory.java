package driver;

import config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class AndroidDriverFactory {

    static AndroidDriver driver;
    public static AndroidDriver createAndroidDriver() throws MalformedURLException {
        CapabilityManager capabilityManager = new CapabilityManager();
        UiAutomator2Options androidOptions =(UiAutomator2Options) capabilityManager.getOptions();

        if(ConfigManager.getExecution().equalsIgnoreCase("local")){
            driver = new AndroidDriver(URI.create(ConfigManager.getAppiumUrl()).toURL(),androidOptions);
        } else if (ConfigManager.getExecution().equalsIgnoreCase("sauce")) {
            driver = new AndroidDriver(URI.create(ConfigManager.getSauceUrl()).toURL(),androidOptions);
        }

        DriverManager.setDriver(driver);
        return driver;
    }
}
