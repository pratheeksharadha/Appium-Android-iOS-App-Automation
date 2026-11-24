package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

public class AppiumServerManager {

    public static AppiumDriverLocalService appiumService;
    private static final Logger logger = LoggerUtils.getLogger(AppiumServerManager.class);
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 4723;

    private AppiumServerManager() {
    }

    public static synchronized AppiumDriverLocalService getServer() {
        return appiumService;
    }

    public static synchronized void startServer(){

        if (appiumService != null && appiumService.isRunning()) {
            logger.info("Appium Server is already running.");
            return;
        }

        logger.info("Starting Appium Server on {}:{}", SERVER_IP, SERVER_PORT);
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress(SERVER_IP)
                .usingPort(SERVER_PORT);

        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);

        try{
            appiumService.start();
            if(!appiumService.isRunning()){
                throw new IllegalStateException(
                        "Appium Server failed to start."
                );
            }
            logger.info("Appium Server started successfully.");
            logger.info("Server URL: {}", appiumService.getUrl());

        }catch (RuntimeException e) {
            logger.error("Failed to start Appium Server.", e);
            appiumService = null;
            throw e;
        }



    }

    public static synchronized  void stopServer(){
        if (appiumService == null || !appiumService.isRunning()) {
            logger.info("Appium Server is not running.");
            return;
        }
        logger.info("Stopping Appium Server");
        appiumService.stop();
        appiumService = null;

        logger.info("Appium Server stopped successfully.");
    }

    public static void restartServer(){
        logger.info("Restarting Appium Server");
        stopServer();
        startServer();
    }
}
