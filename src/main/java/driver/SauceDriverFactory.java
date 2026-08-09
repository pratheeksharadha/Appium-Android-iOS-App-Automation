package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class SauceDriverFactory {

    public AppiumDriver createDriver() throws MalformedURLException {
        String platform = ConfigManager.getPlatform();
        if("Android".equalsIgnoreCase(platform)){
            return AndroidDriverFactory.createAndroidDriver();
        } else if ("iOS".equalsIgnoreCase(platform)) {
            return IOSDriverFactory.createIOSDriver();
        }
        throw new RuntimeException("Unsupported Platform "+ platform);
    }
}
