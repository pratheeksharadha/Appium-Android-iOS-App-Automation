package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCapabilityBuilder extends BaseCpabilityBuilder{

    @Override
    public UiAutomator2Options build() {
        UiAutomator2Options options = new UiAutomator2Options();

        if(ConfigManager.getExecution().equalsIgnoreCase("local")){
            options.setPlatformName(ConfigManager.getPlatformName());
            options.setAutomationName(ConfigManager.getAutomationName());
            options.setUdid(ConfigManager.getUdid());
            options.setApp(ConfigManager.getAppPath());
        } else if (ConfigManager.getExecution().equalsIgnoreCase("sauce")) {
            options.setPlatformName(ConfigManager.getPlatformName());
            options.setAutomationName(ConfigManager.getAutomationName());
            options.setDeviceName(ConfigManager.getDeviceName());
            options.setPlatformVersion(ConfigManager.getplatformVersion());
            options.setApp("storage:" +ConfigManager.getSauceFileID());
        }
        System.out.println(options);
        return options;
    }
}