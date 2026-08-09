package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSCapabilityBuilder extends BaseCpabilityBuilder{

    @Override
    public XCUITestOptions build() {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(ConfigManager.getPlatformName());
        options.setAutomationName(ConfigManager.getAutomationName());
        options.setDeviceName(ConfigManager.getDeviceName());
        options.setApp(ConfigManager.getAppPath());
        System.out.println(options);
        return options;
    }
}
