package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CheckoutPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By firstName = By.id("first-name");
    private final By lastName = By.xpath("(//div//input[@class='input_error form_input'])[2]");
    private final By postalCode = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.xpath("//input[@type='submit']");


    public void verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        Arrays.asList(firstName, lastName, postalCode).forEach(el -> wait.until(visibilityOfElementLocated(el)));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Wrong header url.");
    }

    public void enterFirstName(String firstName) {
        sendKeys(this.firstName, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(this.lastName, lastName);
    }

    public void enterPostalCode(String postalCode) {
        sendKeys(this.postalCode, postalCode);
    }

    public void clickCancelButton() {
        click(cancelButton);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

}
