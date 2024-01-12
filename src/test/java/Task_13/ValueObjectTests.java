package Task_13;

import entities.saucedemo.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageFactory.saucedemo.ShoppingCardPage;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ItemPage;

public class ValueObjectTests extends BaseTest {

    @BeforeTest
    public void setUpTest() {
        get(LoginPage.class).open();
        get(LoginPage.class).login("standard_user", "secret_sauce")
                .clickLogin();
    }


    @Test(dataProvider = "get product")
    public void productTest(Product product) {
        get(ProductPage.class).verifyPage()
                .clickToNameOfProduct(product);
        get(ItemPage.class).clickAddButton()
                .moveToShoppingCard();
        get(ShoppingCardPage.class).clickRemoveFromCard(0);
        Assert.assertEquals(get(ShoppingCardPage.class).getNumberOfProductsInShoppingCard(), 0, "Wrong number of product");
        get(ShoppingCardPage.class).clickContinueShoppingButton();
    }

    @DataProvider(name = "get product")
    public Object[][] getProduct() {
        return new Object[][]{
                {new Product() {{
                    setProductName("Sauce Labs Backpack");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bike Light");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bolt T-Shirt");
                }}},

        };
    }

}
