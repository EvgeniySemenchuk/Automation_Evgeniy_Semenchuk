package Task_7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.ShoppingCardPage;

import static driver.DriverCreation.getDriver;

public class CheckoutTests extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;
    private CheckoutPage checkoutPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        checkoutPage = new CheckoutPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test
    public void checkoutTest1() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        productPage.verifyPage();
        productPage.clickAddToCard(1);
        productPage.clickMoveToShoppingCard();
        shoppingCardPage.verifyPage();
        shoppingCardPage.clickCheckoutButton();
        checkoutPage.verifyPage();
        checkoutPage.enterFirstName("Evgeniy");
        checkoutPage.enterLastName("Semenchuk");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html","Checkout test failed");
    }

}
