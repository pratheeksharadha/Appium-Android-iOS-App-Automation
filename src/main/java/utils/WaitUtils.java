package utils;

import config.ConfigManager;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {
    private WaitUtils(){}

    private static WebDriverWait getWait(){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigManager.getExplicitWait()));
    }

    public static WebElement waitForVisibility(By locator) throws InterruptedException {

        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public static WebElement waitForVisibility(WebElement element) {

        return getWait().until(
                ExpectedConditions.visibilityOf(element));

    }

    public static WebElement waitForClickable(By locator) {

        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator));

    }
    public static WebElement waitForClickable(WebElement element) {

        return getWait().until(
                ExpectedConditions.elementToBeClickable(element));

    }

    public static WebElement waitForPresence(By locator) {

        return getWait().until(
                ExpectedConditions.presenceOfElementLocated(locator));

    }

    public static boolean waitForInvisibility(By locator) {

        return getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public static boolean waitForText(By locator,
                                      String text) {

        return getWait().until(
                ExpectedConditions.textToBe(locator, text));

    }

    public static <T> T waitUntil(ExpectedCondition<T> condition) {

        return getWait().until(condition);

    }



}
