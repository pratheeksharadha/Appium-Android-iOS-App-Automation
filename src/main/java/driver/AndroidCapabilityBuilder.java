package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCapabilityBuilder extends BaseCpabilityBuilder{

    @Override
    public UiAutomator2Options build() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigManager.getPlatformName());
        options.setAutomationName(ConfigManager.getAutomationName());
        options.setDeviceName(ConfigManager.getDeviceName());
        options.setApp(ConfigManager.getAppPath());
        return options;
    }
}