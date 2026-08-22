package pages.PageComponents;

import base.BasePage;
import org.openqa.selenium.WebElement;

public abstract class MobileActions extends BasePage {

    protected void click(WebElement element){
        element.click();
    }

    protected void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected void clear(WebElement element){
        element.clear();
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void isDisplayed(WebElement element, String text){
        element.isDisplayed();
    }

    protected boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    protected String getAttribute(WebElement element,
                                  String attribute) {
        return element.getAttribute(attribute);
    }
}
