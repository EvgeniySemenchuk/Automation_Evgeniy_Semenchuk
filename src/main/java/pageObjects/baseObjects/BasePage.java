package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public class BasePage {

    protected void click(By by) {
        click(getDriver().findElement(by));
    }

    protected void click(WebElement element) {
        System.out.println("Click on element :: " + element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence ... charSequences) {
        sendKeys(getDriver().findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence ... charSequences) {
        System.out.println("Enter in :: " + element + ", next values :: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }
}
