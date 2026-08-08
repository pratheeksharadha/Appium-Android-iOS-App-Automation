import driver.AppiumServerManager;
import org.testng.annotations.Test;

public class appiumServerTest {

    @Test
    public static void testing(){
        AppiumServerManager.startServer();

        System.out.println("Appium server has started");

        //AppiumServerManager.stopServer();

        //System.out.println("Appium server has stoped");

        AppiumServerManager.restartServer();

        System.out.println("Appium server has restarted");

    }

}
