
package driver;

import io.appium.java_client.AppiumDriver;

import java.util.Objects;

public final class DriverManager {

    private static final ThreadLocal<AppiumDriver> DRIVER =
            new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setDriver(AppiumDriver driver) {
        DRIVER.set(
                Objects.requireNonNull(
                        driver,
                        "Cannot register a null Appium driver."
                )
        );
    }

    public static AppiumDriver getDriver() {
        return DRIVER.get();
    }

    public static void unload() {
        DRIVER.remove();
    }
}
