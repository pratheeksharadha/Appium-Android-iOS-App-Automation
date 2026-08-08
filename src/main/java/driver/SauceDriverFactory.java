package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SauceDriverFactory {

    public AppiumDriver createDriver(){
        String platform = ConfigManager.getPlatform();
        if("Android".equalsIgnoreCase(platform)){
            return AndroidDriverFactory.createAndroidDriver();
        } else if ("iOS".equalsIgnoreCase(platform)) {
            return IOSDriverFactory.createIOSDriver();
        }
        throw new RuntimeException("Unsupported Platform "+ platform);
    }
}
