package Task_7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

import static driver.DriverCreation.getDriver;

    public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test
    public void loginTest1() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        Assert.assertNotEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com","Test didn't work");
        getDriver().navigate().back();
    }

    @Test
    public void loginTest2() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        Assert.assertNotEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com","Test didn't work");
        getDriver().navigate().back();
    }

    @Test
    public void loginTest3() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(4));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        Assert.assertNotEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com","Test didn't work");
    }



}
