package Task_9;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.ShoppingCardPage;

public class ProductTests extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;
    private int indexOfAddedProduct = 0;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        loginPage.open();
        loginPage.verifyPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Test(priority = 1,invocationCount = 3,description = "product tests with invocation count")
    public void productTest() {
        productPage.verifyPage();
        productPage.clickAddToCard(indexOfAddedProduct);
        indexOfAddedProduct++;
        productPage.clickMoveToShoppingCard();
        shoppingCardPage.clickRemoveFromCard(0);
        Assert.assertEquals(shoppingCardPage.getNumberOfProductsInShoppingCard(),0,"Wrong number of product");
        shoppingCardPage.clickContinueShoppingButton();
    }


}
