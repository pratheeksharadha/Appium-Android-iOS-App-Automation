package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

public class AppiumServerManager {
    public static AppiumDriverLocalService appiumService;
    private static final Logger logger = LoggerUtils.getLogger(AppiumServerManager.class);

    public static AppiumDriverLocalService getServer(){
        return appiumService;
    }


    public static void startServer(){

        logger.info("Starting Appium Server");
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723);

        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);

        if(appiumService !=null || !appiumService.isRunning()){
            appiumService.start();
            System.out.println("Appium Server started");
        }


    }

    public static void stopServer(){
        logger.info("Stopping Appium Server");
        if( appiumService != null){
            appiumService.stop();
            System.out.println("Appium server has stoped");
        }
    }

    public static void restartServer(){
        logger.info("Restarting Appium Server");
        stopServer();
        startServer();
    }
}
