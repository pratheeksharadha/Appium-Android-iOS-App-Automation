package driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

    public DriverManager(){
    }

    public static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();

    public static void setDriver(AppiumDriver driver){
        DRIVER.set(driver);
    }

    public static AppiumDriver getDriver(){
        return DRIVER.get();
    }

    public static void unload(){
        DRIVER.remove();
    }
}
