package utils;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;

public class AppStateUtils {

    private static final Logger logger =
            LoggerUtils.getLogger(AppStateUtils.class);

    private AppStateUtils() {
    }

    private static AndroidDriver getDriver() {

        return (AndroidDriver) DriverManager.getDriver();

    }

    /**
     * Install application.
     *
     * @param appPath path to APK
     */
    public static void installApp(String appPath) {

        logger.info("Installing application : {}", appPath);

        getDriver().installApp(appPath);

        logger.info("Application installed successfully.");

    }

    /**
     * Remove application.
     *
     * @param packageName Android package name
     */
    public static void removeApp(String packageName) {

        logger.info("Removing application : {}", packageName);

        getDriver().removeApp(packageName);

        logger.info("Application removed successfully.");

    }

    /**
     * Activate application.
     *
     * @param packageName Android package name
     */
    public static void activateApp(String packageName) {

        logger.info("Activating application : {}", packageName);

        getDriver().activateApp(packageName);

        logger.info("Application activated.");

    }

    /**
     * Terminate application.
     *
     * @param packageName Android package name
     */
    public static void terminateApp(String packageName) {

        logger.info("Terminating application : {}", packageName);

        getDriver().terminateApp(packageName);

        logger.info("Application terminated.");

    }

    /**
     * Check whether application is installed.
     *
     * @param packageName Android package name
     * @return true if installed
     */
    public static boolean isAppInstalled(String packageName) {

        boolean installed =
                getDriver().isAppInstalled(packageName);

        logger.info(
                "Application {} installed : {}",
                packageName,
                installed);

        return installed;

    }



}
