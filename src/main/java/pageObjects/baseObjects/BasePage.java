package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);
    }

    protected void navigateTo(String url) {
        System.out.println("Navigate to :: " + url);
        driver.get(url);
    }


    protected void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        click(getDriver().findElement(by));
    }

    protected void click(WebElement element) {
        System.out.println("Click on element :: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(By by, CharSequence ... charSequences) {
        sendKeys(driver.findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence ... charSequences) {
        System.out.println("Enter in :: " + element + ", next values :: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }
}
