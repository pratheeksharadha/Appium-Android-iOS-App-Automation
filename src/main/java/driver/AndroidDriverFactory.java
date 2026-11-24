
package driver;

import config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

import java.net.MalformedURLException;
import java.net.URI;

public final class AndroidDriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(AndroidDriverFactory.class);

    private AndroidDriverFactory() {
    }

    public static AndroidDriver createAndroidDriver(String serverUrl)
            throws MalformedURLException {

        if (serverUrl == null || serverUrl.isBlank()) {
            throw new IllegalArgumentException(
                    "Appium server URL cannot be null or blank."
            );
        }

        logger.info("Creating Android driver");
        logger.info("Appium Server URL: {}", serverUrl);

        try {
            CapabilityManager capabilityManager = new CapabilityManager();

            Object capabilities = capabilityManager.getOptions();

            if (!(capabilities instanceof UiAutomator2Options options)) {
                throw new IllegalStateException(
                        "Android execution requires UiAutomator2Options, but received: "
                                + (capabilities == null
                                ? "null"
                                : capabilities.getClass().getName())
                );
            }

            AndroidDriver driver = new AndroidDriver(
                    URI.create(serverUrl).toURL(),
                    options
            );

            logger.info(
                    "Android driver created successfully. Platform: {}",
                    ConfigManager.getPlatformName()
            );

            return driver;

        } catch (MalformedURLException e) {
            logger.error("Invalid Appium server URL: {}", serverUrl, e);
            throw e;
        } catch (RuntimeException e) {
            logger.error("Failed to create Android driver.", e);
            throw e;
        }
    }
}
