
package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static AppiumDriver createDriver() throws MalformedURLException {

        String execution = ConfigManager.getExecution();

        if ("local".equalsIgnoreCase(execution)) {
            return LocalDriverFactory.createDriver();
        }

        if ("sauce".equalsIgnoreCase(execution)) {
            return SauceDriverFactory.createDriver();
        }

        throw new IllegalArgumentException(
                "Unsupported execution type: " + execution
        );
    }
}
