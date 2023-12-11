package Task_7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.ShoppingCardPage;

public class ShoppingCardTests extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShoppingCardPage shoppingCardPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        shoppingCardPage = new ShoppingCardPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test
    public void removeFromShoppingCardTest() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLoginButton();
        productPage.verifyPage();
        productPage.clickAddToCard(1);
        productPage.clickAddToCard(2);
        productPage.clickMoveToShoppingCard();
        shoppingCardPage.verifyPage();
        Integer currentNumberOfProducts = shoppingCardPage.getNumberOfProductsInShoppingCard();
        shoppingCardPage.clickRemoveFromCard(0);
        Assert.assertNotEquals(shoppingCardPage.getNumberOfProductsInShoppingCard(), currentNumberOfProducts,"Remove from shopping card failed");
    }

}
