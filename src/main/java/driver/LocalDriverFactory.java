
package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public final class LocalDriverFactory {

    private LocalDriverFactory() {
    }

    public static AppiumDriver createDriver() throws MalformedURLException {

        String platform = ConfigManager.getPlatformName();
        String serverUrl = ConfigManager.getAppiumUrl();

        if ("Android".equalsIgnoreCase(platform)) {
            return AndroidDriverFactory.createAndroidDriver(serverUrl);
        }

        if ("iOS".equalsIgnoreCase(platform)) {
            throw new UnsupportedOperationException(
                    "Local iOS execution is not supported in the current "
                            + "Windows environment. Use Sauce Labs for iOS execution."
            );
        }

        throw new IllegalArgumentException(
                "Unsupported local platform: " + platform
        );
    }
}
