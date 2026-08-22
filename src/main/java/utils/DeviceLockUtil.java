package utils;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class DeviceLockUtil {

    private static final Logger logger =
            LoggerUtils.getLogger(DeviceLockUtil.class);

    private DeviceLockUtil() {
    }

    private static AndroidDriver getDriver() {
        return (AndroidDriver) DriverManager.getDriver();
    }

    /**
     * Lock device immediately.
     */
    public static void lockDevice() {

        logger.info("Locking device.");

        getDriver().lockDevice();

        logger.info("Device locked successfully.");

    }

    /**
     * Lock device for specified duration.
     *
     * @param seconds lock duration
     */
    public static void lockDevice(long seconds) {

        logger.info("Locking device for {} seconds.", seconds);

        getDriver().lockDevice(Duration.ofSeconds(seconds));

        logger.info("Device locked successfully.");

    }

    /**
     * Unlock device.
     */
    public static void unlockDevice() {

        logger.info("Unlocking device.");

        getDriver().unlockDevice();

        logger.info("Device unlocked successfully.");

    }

    /**
     * Check whether device is locked.
     *
     * @return true if locked
     */
    public static boolean isDeviceLocked() {

        boolean locked = getDriver().isDeviceLocked();

        logger.info("Device Locked : {}", locked);

        return locked;

    }
}
