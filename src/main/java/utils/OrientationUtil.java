package utils;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ScreenOrientation;

public class OrientationUtil {

    private static final Logger logger =
            LoggerUtils.getLogger(OrientationUtil.class);

    private OrientationUtil() {
    }

    private static AndroidDriver getDriver() {
        return (AndroidDriver) DriverManager.getDriver();
    }

    /**
     * Rotate device to Portrait.
     */
    public static void rotateToPortrait() {

        logger.info("Rotating device to PORTRAIT.");

        getDriver().rotate(ScreenOrientation.PORTRAIT);

        logger.info("Device rotated to PORTRAIT.");

    }

    /**
     * Rotate device to Landscape.
     */
    public static void rotateToLandscape() {

        logger.info("Rotating device to LANDSCAPE.");

        getDriver().rotate(ScreenOrientation.LANDSCAPE);

        logger.info("Device rotated to LANDSCAPE.");

    }

    /**
     * Get current device orientation.
     *
     * @return ScreenOrientation
     */
    public static ScreenOrientation getOrientation() {

        ScreenOrientation orientation =
                getDriver().getOrientation();

        logger.info("Current Orientation : {}", orientation);

        return orientation;

    }
}
