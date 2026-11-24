
package driver;

import config.ConfigManager;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSCapabilityBuilder
        extends BaseCapabilityBuilder<XCUITestOptions> {

    @Override
    public XCUITestOptions build() {

        String execution = ConfigManager.getExecution();

        if (!"sauce".equalsIgnoreCase(execution)) {
            throw new UnsupportedOperationException(
                    "iOS execution is supported only through Sauce Labs "
                            + "in the current Windows environment."
            );
        }

        XCUITestOptions options = new XCUITestOptions();

        options.setPlatformName(
                ConfigManager.getPlatformName()
        );

        options.setAutomationName(
                ConfigManager.getAutomationName()
        );

        options.setDeviceName(requireValue(
                ConfigManager.getDeviceName(),
                "Sauce Labs iOS device name"
        ));

        options.setPlatformVersion(requireValue(
                ConfigManager.getPlatformVersion(),
                "Sauce Labs iOS platform version"
        ));

        String sauceFileId = requireValue(
                ConfigManager.getSauceFileID(),
                "Sauce Labs iOS application ID"
        );

        options.setApp("storage:" + sauceFileId);

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
