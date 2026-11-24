
package tests;

import config.ConfigManager;
import driver.CapabilityManager;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationVerificationTest {

    @Test
    public void verifyAndroidConfiguration() {

        String execution = ConfigManager.getExecution();

        Assert.assertEquals(
                ConfigManager.getPlatform(), "Android"
        );

        Assert.assertEquals(
                ConfigManager.getEnvironment(), "qa"
        );

        Assert.assertEquals(
                ConfigManager.getPlatformName(), "Android"
        );

        Assert.assertEquals(
                ConfigManager.getAutomationName(), "UiAutomator2"
        );

        Capabilities capabilities =
                new CapabilityManager().getOptions();

        Assert.assertNotNull(capabilities);

        if ("local".equalsIgnoreCase(execution)) {

            Assert.assertNotNull(ConfigManager.getUdid());
            Assert.assertNotNull(ConfigManager.getAppPath());
            Assert.assertNotNull(ConfigManager.getAppiumUrl());

            Assert.assertEquals(
                    capabilities.getCapability("appium:udid"),
                    ConfigManager.getUdid()
            );

        } else if ("sauce".equalsIgnoreCase(execution)) {

            Assert.assertNotNull(ConfigManager.getDeviceName());
            Assert.assertNotNull(ConfigManager.getPlatformVersion());
            Assert.assertNotNull(ConfigManager.getSauceFileID());

            Assert.assertNotNull(
                    capabilities.getCapability("sauce:options")
            );

        } else {
            Assert.fail("Unsupported execution: " + execution);
        }

        System.out.println(
                "Android configuration verified for: " + execution
        );
    }
}
