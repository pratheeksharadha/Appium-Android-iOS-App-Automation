
package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;

public final class CapabilityManager {

    public Capabilities getOptions() {

        String execution = ConfigManager.getExecution();
        String platform = ConfigManager.getPlatformName();

        validateExecution(execution, platform);

        if ("Android".equalsIgnoreCase(platform)) {

            UiAutomator2Options options =
                    new AndroidCapabilityBuilder().build();

            attachSauceOptions(options, execution);

            return options;
        }

        if ("iOS".equalsIgnoreCase(platform)) {

            XCUITestOptions options =
                    new IOSCapabilityBuilder().build();

            attachSauceOptions(options, execution);

            return options;
        }

        throw new IllegalArgumentException(
                "Unsupported platform: " + platform
        );
    }

    private void validateExecution(String execution, String platform) {

        if (!"local".equalsIgnoreCase(execution)
                && !"sauce".equalsIgnoreCase(execution)) {

            throw new IllegalArgumentException(
                    "Unsupported execution type: " + execution
            );
        }

        if ("local".equalsIgnoreCase(execution)
                && "iOS".equalsIgnoreCase(platform)) {

            throw new UnsupportedOperationException(
                    "Local iOS execution is not supported. "
                            + "Use Sauce Labs for iOS execution."
            );
        }
    }

    private void attachSauceOptions(
            MutableCapabilities options,
            String execution
    ) {

        if ("sauce".equalsIgnoreCase(execution)) {

            options.setCapability(
                    "sauce:options",
                    new SauceCapabilityBuilder().build()
            );
        }
    }
}
