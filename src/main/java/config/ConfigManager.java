package config;

public class ConfigManager {

    private ConfigManager(){}

    public static String getExecution(){
        return PropertyManager.getConfig("execution");
    }

    public static String getPlatform(){
        return PropertyManager.getConfig("platform");
    }

    public static String getEnvironment(){
        return PropertyManager.getConfig("environment");
    }

    public static String getImplicitWait(){
        return PropertyManager.getConfig("implicit.wait");
    }

    public static String getExplicitWait(){
        return PropertyManager.getConfig("explicit.wait");
    }

    public static String getAppiumUrl(){
        return PropertyManager.getConfig("appium.url");
    }

    public static String getAppPath(){
        return PropertyManager.getEnvironment("app.path");
    }
    public static String getApiTimeout(){
        return PropertyManager.getEnvironment("api.timeout");
    }
    public static String getPlatformName(){
        return PropertyManager.getDevice("platformName");
    }
    public static String getAutomationName(){
        return PropertyManager.getDevice("automationName");
    }
    public static String getDeviceName(){
        return PropertyManager.getDevice("deviceName");
    }
    public static String getSauceUsername(){
        return PropertyManager.getSauce("username");
    }
    public static String getSauceAccessKey(){
        return PropertyManager.getSauce("accessKey");
    }
    public static String getSauceUrl(){
        return PropertyManager.getSauce("url");
    }


}
