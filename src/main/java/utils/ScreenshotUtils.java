package utils;

import constants.FrameworkConstants;
import driver.DriverManager;
import freemarker.template.utility.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private static final Logger logger =
            LoggerUtils.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }

    /**
     * Capture screenshot.
     *
     * @param fileName screenshot name
     * @return screenshot path
     */
    public static String captureScreenshot(String fileName) {

        File source = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String screenshotPath =
                FrameworkConstants.SCREENSHOT_PATH +
                        fileName + "_" +
                        DateUtils.getTimeStamp() + ".png";

        File destination = new File(screenshotPath);

        try {

            FileUtils.copyFile(source, destination);

            logger.info("Screenshot saved : {}", screenshotPath);

        } catch (IOException e) {

            logger.error("Unable to capture screenshot.", e);

            throw new RuntimeException("Screenshot capture failed.", e);

        }

        return screenshotPath;

    }
}
