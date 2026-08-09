package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerManager {
    public static AppiumDriverLocalService appiumService;

    public static AppiumDriverLocalService getServer(){
        return appiumService;
    }

    public static void startServer(){

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
        if( appiumService != null){
            appiumService.stop();
            System.out.println("Appium server has stoped");
        }
    }

    public static void restartServer(){
        stopServer();
        startServer();
    }
}
