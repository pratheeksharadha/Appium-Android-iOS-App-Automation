
package config;

public final class ConfigManager {

    private ConfigManager() {
    }

    public static String getExecution() {
        return PropertyManager.getConfig("execution");
    }

    public static String getPlatform() {
        return PropertyManager.getConfig("platform");
    }

    public static String getEnvironment() {
        return PropertyManager.getConfig("environment");
    }

    public static String getImplicitWait() {
        return PropertyManager.getConfig("implicit.wait");
    }

    public static long getExplicitWait() {
        return Long.parseLong(
                PropertyManager.getConfig("explicit.wait")
        );
    }

    public static String getAppiumUrl() {
        return PropertyManager.getConfig("appium.url");
    }

    public static String getAppPath() {
        String platform = getPlatform();

        if ("Android".equalsIgnoreCase(platform)) {
            return PropertyManager.getEnvironment("Android_app.path");
        }

        if ("iOS".equalsIgnoreCase(platform)) {
            return PropertyManager.getEnvironment("iOS_app.path");
        }

        throw new IllegalArgumentException(
                "Unsupported platform: " + platform
        );
    }

    public static String getApiTimeout() {
        return PropertyManager.getEnvironment("api.timeout");
    }

    public static String getPlatformName() {
        return PropertyManager.getDevice("platformName");
    }

    public static String getAutomationName() {
        return PropertyManager.getDevice("automationName");
    }

    public static String getDeviceName() {
        return PropertyManager.getDevice("deviceName");
    }

    public static String getUdid() {
        return PropertyManager.getDevice("udid");
    }

    public static String getPlatformVersion() {
        return PropertyManager.getDevice("platformVersion");
    }

    public static String getSauceUsername() {
        return PropertyManager.getSauce("username");
    }

    public static String getSauceAccessKey() {
        return PropertyManager.getSauce("accessKey");
    }

    public static String getSauceUrl() {
        return PropertyManager.getSauce("url");
    }

    public static String getSauceFileID() {
        String platform = getPlatform();

        if ("Android".equalsIgnoreCase(platform)) {
            return PropertyManager.getEnvironment("Android_sauceFileID");
        }

        if ("iOS".equalsIgnoreCase(platform)) {
            return PropertyManager.getEnvironment("iOS_sauceFileID");
        }

        throw new IllegalArgumentException(
                "Unsupported platform: " + platform
        );
    }

    public static String getSauceBuildName() {
        return PropertyManager.getSauce("build.name");
    }

    public static String getSauceTestName() {
        return PropertyManager.getSauce("test.name");
    }
}
