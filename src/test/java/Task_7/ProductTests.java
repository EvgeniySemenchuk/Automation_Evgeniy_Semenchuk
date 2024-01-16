package Task_7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

import static driver.DriverCreation.getDriver;

public class ProductTests extends BaseTest {

    private ProductPage productPage;
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test
    public void addToShoppingCardTest() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        productPage.verifyPage();
        productPage.clickAddToCard(1);
        Assert.assertEquals(productPage.getNumberOfProductsInShoppingCard(), "1", "SomeTest didn't work");
    }


}
