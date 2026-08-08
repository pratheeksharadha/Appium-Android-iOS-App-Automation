package config;

import constants.FrameworkConstants;

public class PropertyManager {

    private static ConfigReader configReader;
    private static ConfigReader environmentReader;
    private static ConfigReader deviceReader;
    private static ConfigReader sauceReader;

    static{
        configReader = new ConfigReader(FrameworkConstants.CONFIG_PATH);
        String environment = configReader.getProperty("environment");
        String platform = configReader.getProperty("platform");
        String execution = configReader.getProperty("execution");


        environmentReader = new ConfigReader(FrameworkConstants.CONFIG_FOLDER +environment+".properties");

        deviceReader = new ConfigReader(FrameworkConstants.CONFIG_FOLDER +platform+".properties");

        if("sauce".equalsIgnoreCase(execution)){
            sauceReader = new ConfigReader(FrameworkConstants.CONFIG_FOLDER +"sauce.properties");
        }


    }

    public PropertyManager(){

    }

    public static String getConfig(String key){
        return configReader.getProperty(key);
    }

    public static String getEnvironment(String key){
        return environmentReader.getProperty(key);
    }

    public static String getDevice(String key){
        return deviceReader.getProperty(key);
    }

    public static String getSauce(String key){
        if(sauceReader==null){
            return null;
        }
        return sauceReader.getProperty(key);
    }
}
