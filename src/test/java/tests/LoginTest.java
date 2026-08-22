package tests;

import driver.AppiumServerManager;
import driver.DriverManager;
import hooks.BaseHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitUtils;

import java.net.MalformedURLException;

public class LoginTest extends BaseHooks {

    private static final Logger log =
            LoggerFactory.getLogger(LoginTest.class);
    @Test
    public void loginTest() throws MalformedURLException, InterruptedException {
        //initializeDriver();
//        log.info("This is an INFO message");
//        log.warn("This is a WARNING message");
//        log.error("This is an ERROR message");
//
//        //Assert.fail();
//        WaitUtils.waitForClickable(By.id("com.saucelabs.mydemoapp.android:id/cartIV"));
//        DriverManager.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/cartIV")).click();
//        DriverManager.getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/shoppingBt"));


    }
}
