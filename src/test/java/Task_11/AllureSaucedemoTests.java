package Task_11;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.ShoppingCardPage;

public class AllureSaucedemoTests extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        loginPage.open();
    }

    @Description("SomeTest of adding and deleting product in shopping card")
    @Step("login to saucedemo")
    @Test(priority = 1)
    public void loginTests() {
        loginPage.verifyPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @Description("SomeTest of adding and deleting product in shopping card")
    @Step("Add product to shopping card")
    @Test(priority = 2)
    public void productTest() {
        productPage.verifyPage();
        productPage.clickAddToCard(0);
        Assert.assertEquals(productPage.getNumberOfProductsInShoppingCard(),"1","Wrong number of product");
        productPage.clickMoveToShoppingCard();
    }

    @Description("SomeTest of adding and deleting product in shopping card")
    @Step("Delete product from shopping card")
    @Test(priority = 3)
    public void shoppingCardTest() {
        shoppingCardPage.clickRemoveFromCard(0);
        Assert.assertEquals(shoppingCardPage.getNumberOfProductsInShoppingCard(),0,"Wrong number of product");
    }

}
