package pageObjects.baseObjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
@Log4j
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
        log.info("Navigate to :: " + url);
        driver.get(url);
    }


    protected void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        click(getDriver().findElement(by));
    }

    protected void click(WebElement element) {
        log.info("Click on element :: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(By by, CharSequence ... charSequences) {
        sendKeys(driver.findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence ... charSequences) {
        log.info("Enter in :: " + element + ", next values :: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getElementText(By by) {
        return getElementText(driver.findElement(by));
    }

    protected List<String> getElementTexts(By by) {
        return getElementTexts(driver.findElements(by));
    }

    protected List<String> getElementTexts(List<WebElement> webElements) {
        return webElements.stream().map(data -> data.getText()).collect(Collectors.toList());
    }

    protected void waitUntilTextToBe(By by, String expectedText) {
        log.info("Wait until text to be " + expectedText);
        wait.until(ExpectedConditions.textToBe(by,expectedText));
    }

    protected void waitUntilTextNoToBe(By by, String expectedText) {
        log.info("Wait until text not to be " + expectedText);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(by,expectedText)));
    }

    protected void waitUntilElementToBeClickable(WebElement webElement) {
        log.info("Wait for element to be clickable " + webElement);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntilElementToBeClickable(By by) {
        waitUntilElementToBeClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeNotClickable(By by) {
        waitUntilElementToBeNotClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeNotClickable(WebElement webElement) {
        log.info("Wait until element not to be clickable  :: " + webElement);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
    }

}
