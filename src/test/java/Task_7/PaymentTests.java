package Task_7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

import static driver.DriverCreation.getDriver;

public class PaymentTests extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test
    public void paymentTestOfCorrectPriceAndSuccessfulFinish() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
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
        paymentPage.verifyPage();
        paymentPage.clickFinishPaymentButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "Payment failed");
    }

}
