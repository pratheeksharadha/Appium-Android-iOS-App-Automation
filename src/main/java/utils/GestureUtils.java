package utils;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Map;

public final class GestureUtils {

    private GestureUtils(){
    }

    public static void tap(WebElement element){
        element.click();
    }

    public static void doubleTap(WebElement element) {
        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "mobile: doubleClickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId()));
    }

    public static void longPress(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "mobile: longClickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId(),
                        "duration",
                        2000));
    }

    public static void swipe(
            String direction) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 100,
                        "top", 100,
                        "width", 500,
                        "height", 1000,
                        "direction", direction,
                        "percent", 0.75));

    }

    public static void scroll(String direction) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", 100,
                        "top", 100,
                        "width", 500,
                        "height", 1000,
                        "direction", direction,
                        "percent", 0.75));

    }

    public static void dragAndDrop(
            WebElement element,
            int endX,
            int endY) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "mobile: dragGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId(),
                        "endX",
                        endX,
                        "endY",
                        endY));

    }

    public static void pinch(
            WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "mobile: pinchCloseGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId(),
                        "percent",
                        0.75));

    }
    public static void zoom(
            WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "mobile: pinchOpenGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId(),
                        "percent",
                        0.75));

    }
}
