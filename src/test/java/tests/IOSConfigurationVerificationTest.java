package tests;

import config.ConfigManager;
import driver.CapabilityManager;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSConfigurationVerificationTest {

    @Test
    public void verifyIOSConfiguration() {

        Assert.assertEquals(ConfigManager.getExecution(), "sauce");
        Assert.assertEquals(ConfigManager.getPlatform(), "ios");
        Assert.assertEquals(ConfigManager.getPlatformName(), "ios");
        Assert.assertEquals(ConfigManager.getAutomationName(), "XCUITest");

        Assert.assertNotNull(ConfigManager.getDeviceName());
        Assert.assertNotNull(ConfigManager.getPlatformVersion());
        Assert.assertNotNull(ConfigManager.getSauceFileID());

        Capabilities capabilities = new CapabilityManager().getOptions();

        Assert.assertNotNull(capabilities);
        Assert.assertTrue(
                capabilities instanceof XCUITestOptions,
                "Expected XCUITestOptions for iOS execution."
        );

        Assert.assertNotNull(
                capabilities.getCapability("sauce:options"),
                "Sauce Labs options should be configured."
        );

        System.out.println("iOS Sauce configuration verified successfully.");
    }
}