package driver;

import config.ConfigManager;
import org.openqa.selenium.MutableCapabilities;

public final class SauceCapabilityBuilder {

    public MutableCapabilities build() {

        MutableCapabilities sauceOptions = new MutableCapabilities();

        sauceOptions.setCapability(
                "build",
                ConfigManager.getSauceBuildName()
        );

        sauceOptions.setCapability(
                "name",
                ConfigManager.getSauceTestName()
        );

        sauceOptions.setCapability(
                "username",
                ConfigManager.getSauceUsername()
        );

        sauceOptions.setCapability(
                "accessKey",
                ConfigManager.getSauceAccessKey()
        );

        // We will verify the supported Appium version before a live Sauce run.
        sauceOptions.setCapability("appiumVersion", "appium3-2026-07");

        return sauceOptions;
    }
}