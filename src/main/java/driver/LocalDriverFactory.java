package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

public class LocalDriverFactory {

    public AppiumDriver createDriver(){
        String platform = ConfigManager.getPlatform();
        if("Android".equalsIgnoreCase(platform)){
            return new AndroidDriverFactory().createAndroidDriver();
        } else if ("iOS".equalsIgnoreCase(platform)) {
            return new IOSDriverFactory().createIOSDriver();
        }
        throw new RuntimeException("Unsupported Platform " +platform);
    }
}
