package driver;

import config.ConfigManager;
import org.openqa.selenium.MutableCapabilities;

public class SauceCapabilityBuilder {

    public MutableCapabilities build(){
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "Mobile Framework");
        sauceOptions.setCapability("name", "Automation Test");
        sauceOptions.setCapability("username", ConfigManager.getSauceUsername());
        sauceOptions.setCapability("accessKey", ConfigManager.getSauceAccessKey());
        sauceOptions.setCapability("appiumVersion","appium3-2026-07");
        System.out.println(sauceOptions);
        return sauceOptions;
    }
}
