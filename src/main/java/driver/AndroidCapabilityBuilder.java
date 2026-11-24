
package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCapabilityBuilder
        extends BaseCapabilityBuilder<UiAutomator2Options> {

    @Override
    public UiAutomator2Options build() {

        String execution = ConfigManager.getExecution();

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(ConfigManager.getPlatformName());
        options.setAutomationName(ConfigManager.getAutomationName());

        if ("local".equalsIgnoreCase(execution)) {

            options.setUdid(requireValue(
                    ConfigManager.getUdid(),
                    "Android UDID"
            ));

            options.setApp(requireValue(
                    ConfigManager.getAppPath(),
                    "Local Android application path"
            ));

        } else if ("sauce".equalsIgnoreCase(execution)) {

            options.setDeviceName(requireValue(
                    ConfigManager.getDeviceName(),
                    "Sauce Labs device name"
            ));

            options.setPlatformVersion(requireValue(
                    ConfigManager.getPlatformVersion(),
                    "Sauce Labs platform version"
            ));

            String sauceFileId = requireValue(
                    ConfigManager.getSauceFileID(),
                    "Sauce Labs application ID"
            );

            options.setApp("storage:" + sauceFileId);

        } else {

            throw new IllegalArgumentException(
                    "Unsupported execution type: " + execution
            );
        }

        return options;
    }

    private String requireValue(String value, String propertyName) {

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing required configuration: " + propertyName
            );
        }

        return value.trim();
    }
}
