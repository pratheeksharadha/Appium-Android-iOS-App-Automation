package driver;

import org.openqa.selenium.MutableCapabilities;

public class SauceCapabilityBuilder {

    public MutableCapabilities build(){
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "Mobile Framework");
        sauceOptions.setCapability("name", "Automation Test");
        return sauceOptions;
    }
}
