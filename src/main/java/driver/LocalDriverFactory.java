package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class LocalDriverFactory {

    public AppiumDriver createDriver() throws MalformedURLException {
        String platform = ConfigManager.getPlatform();
        if("Android".equalsIgnoreCase(platform)){
            System.out.println("Android platform createAndroidDriver");
            return AndroidDriverFactory.createAndroidDriver();
        } else if ("iOS".equalsIgnoreCase(platform)) {
            System.out.println("iOS platform createAndroidDriver");
            return IOSDriverFactory.createIOSDriver();
        }
        throw new RuntimeException("Unsupported Platform " +platform);
    }
}
