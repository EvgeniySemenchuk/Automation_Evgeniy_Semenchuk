package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static propertyUtils.PropertyReader.*;

public class LoginPage extends BasePage {

    private final By header = By.className("login_logo");
    private final By username = By.id("user-name");
    private final By password = By.name("password");
    private final By loginButton = By.cssSelector("input[value = 'Login']");
    private final By loginCredentials = By.id("login_credentials");
    private final By passwordCredentials = By.className("login_password");

    public void open(String url) {
        getDriver().get(url);
    }

    public void open() {
        getDriver().get(getProperties().getProperty("url"));
    }

    public void verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        Arrays.asList(username, password, loginButton).forEach(el -> wait.until(visibilityOfElementLocated(el)));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong page url");
    }

    public void enterUsername(String username) {
        sendKeys(this.username, username);
    }

   public void enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
    }

    public void enterPassword(String password) {
        sendKeys(this.password, password);
    }

    public void enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public List<String> getUsernames() {
        return Arrays.stream(getDriver().findElement(loginCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return Arrays.stream(getDriver().findElement(passwordCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }


}
