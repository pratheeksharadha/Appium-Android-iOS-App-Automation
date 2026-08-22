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

    public static Long getExplicitWait(){
        return Long.parseLong(PropertyManager.getConfig("explicit.wait"));
    }

    public static String getAppiumUrl(){
        return PropertyManager.getConfig("appium.url");
    }

    public static String getAppPath(){
        String app_path="";
        if("Android".equalsIgnoreCase(PropertyManager.getConfig(("platform")))){
            app_path = PropertyManager.getEnvironment("Android_app.path");
        } else if ("iOS".equalsIgnoreCase(PropertyManager.getConfig(("platform")))) {
            app_path = PropertyManager.getEnvironment("iOS_app.path");
        }
        System.out.println("App Path ="+app_path);
        return app_path;
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

    public static String getUdid(){
        return PropertyManager.getDevice("udid");
    }

    public static String getPlatformVersion(){
        return PropertyManager.getDevice("platformVersion");
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

    public static String getSauceFileID(){
        String sauceFileId = "";
        if("iOS".equalsIgnoreCase(PropertyManager.getConfig("platform"))){
            sauceFileId = PropertyManager.getEnvironment("iOS_sauceFileID");
        } else if ("Android".equalsIgnoreCase(PropertyManager.getConfig("platform"))) {
            sauceFileId = PropertyManager.getEnvironment("Android_sauceFileID");
        }

        System.out.println("Sauce_file_ID" +sauceFileId);
        return sauceFileId;
    }


}
