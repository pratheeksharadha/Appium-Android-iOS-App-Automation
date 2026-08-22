package utils;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.Logger;

public class KeyBoardUtils {

    private static final Logger logger =
            LoggerUtils.getLogger(KeyBoardUtils.class);

    private KeyBoardUtils() {
    }

    private static AndroidDriver getDriver() {

        return (AndroidDriver) DriverManager.getDriver();

    }

    /**
     * Hide Android Keyboard
     */
    public static void hideKeyboard() {

        try {

            getDriver().hideKeyboard();

            logger.info("Keyboard hidden successfully.");

        } catch (Exception e) {

            logger.warn("Keyboard was not visible.");

        }

    }

    /**
     * Check Keyboard Visibility
     */
    public static boolean isKeyboardShown() {

        boolean status = getDriver().isKeyboardShown();

        logger.info("Keyboard Visible : {}", status);

        return status;

    }

    /**
     * Press Any Android Key
     */
    public static void pressKey(AndroidKey key) {

        logger.info("Pressing Key : {}", key);

        getDriver().pressKey(new KeyEvent(key));

    }

    /**
     * Press Enter Key
     */
    public static void pressEnter() {

        pressKey(AndroidKey.ENTER);

    }

    /**
     * Press Back Button
     */
    public static void pressBack() {

        pressKey(AndroidKey.BACK);

    }

}
