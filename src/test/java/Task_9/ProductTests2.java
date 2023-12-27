package Task_9;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class ProductTests2 extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;
    private ItemPage itemPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        itemPage = new ItemPage();
        loginPage.open();
        loginPage.verifyPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Test(priority = 1,dataProvider = "product test2",description = "product tests with data provider")
    public void productTest(String nameOfProduct) {
        productPage.verifyPage();
        productPage.clickToNameOfProduct(nameOfProduct);
        itemPage.clickAddButton();
        itemPage.moveToShoppingCard();
        shoppingCardPage.clickRemoveFromCard(0);
        Assert.assertEquals(shoppingCardPage.getNumberOfProductsInShoppingCard(),0,"Wrong number of product");
        shoppingCardPage.clickContinueShoppingButton();
    }

    @DataProvider(name = "product test2")
    public Object[][] getData() {
        return new Object[][] {
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
        };
    }

}
