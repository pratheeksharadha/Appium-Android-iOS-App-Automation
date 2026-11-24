
package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public final class SauceDriverFactory {

    private SauceDriverFactory() {
    }

    public static AppiumDriver createDriver() throws MalformedURLException {

        String platform = ConfigManager.getPlatformName();
        String serverUrl = ConfigManager.getSauceUrl();

        if ("Android".equalsIgnoreCase(platform)) {
            return AndroidDriverFactory.createAndroidDriver(serverUrl);
        }

        if ("iOS".equalsIgnoreCase(platform)) {
            return IOSDriverFactory.createIOSDriver(serverUrl);
        }

        throw new IllegalArgumentException(
                "Unsupported Sauce Labs platform: " + platform
        );
    }
}
