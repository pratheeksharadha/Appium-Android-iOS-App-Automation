package tests;

import driver.AppiumServerManager;
import hooks.BaseHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends BaseHooks {

    private static final Logger log =
            LoggerFactory.getLogger(LoginTest.class);
    @Test
    public void loginTest() throws MalformedURLException {
        //initializeDriver();
        log.info("This is an INFO message");
        log.warn("This is a WARNING message");
        log.error("This is an ERROR message");

        //Assert.fail();



    }
}
