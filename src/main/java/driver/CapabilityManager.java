package driver;

import config.ConfigManager;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;

import java.util.Objects;

public class CapabilityManager {
    Object options;

    public Object getOptions(){

        if(ConfigManager.getPlatformName().equalsIgnoreCase("Android")){
            options = new AndroidCapabilityBuilder().build();
        } else if (ConfigManager.getPlatformName().equalsIgnoreCase("IOS")) {
            options = new IOSCapabilityBuilder().build();
        }

        if(ConfigManager.getExecution().equalsIgnoreCase("sauce")){
            MutableCapabilities sauceOptions = new SauceCapabilityBuilder().build();

            if (options instanceof UiAutomator2Options androidOptions) {
                androidOptions.setCapability("sauce:options", sauceOptions);
            } else if (options instanceof XCUITestOptions iosOptions) {
                iosOptions.setCapability("sauce:options", sauceOptions);
            }
        }
        return options;
    }

}
