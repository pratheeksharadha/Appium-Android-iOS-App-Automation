
package driver;

import config.ConfigManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

import java.net.MalformedURLException;
import java.net.URI;

public final class IOSDriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(IOSDriverFactory.class);

    private IOSDriverFactory() {
    }

    public static IOSDriver createIOSDriver(String serverUrl)
            throws MalformedURLException {

        if (serverUrl == null || serverUrl.isBlank()) {
            throw new IllegalArgumentException(
                    "Appium server URL cannot be null or blank."
            );
        }

        logger.info("Creating iOS driver");
        logger.info("Sauce Labs URL: {}", serverUrl);

        try {
            CapabilityManager capabilityManager = new CapabilityManager();

            Object capabilities = capabilityManager.getOptions();

            if (!(capabilities instanceof XCUITestOptions options)) {
                throw new IllegalStateException(
                        "iOS execution requires XCUITestOptions, but received: "
                                + (capabilities == null
                                ? "null"
                                : capabilities.getClass().getName())
                );
            }

            IOSDriver driver = new IOSDriver(
                    URI.create(serverUrl).toURL(),
                    options
            );

            logger.info(
                    "iOS driver created successfully. Platform: {}",
                    ConfigManager.getPlatformName()
            );

            return driver;

        } catch (MalformedURLException e) {
            logger.error("Invalid Sauce Labs URL: {}", serverUrl, e);
            throw e;
        } catch (RuntimeException e) {
            logger.error("Failed to create iOS driver.", e);
            throw e;
        }
    }
}
