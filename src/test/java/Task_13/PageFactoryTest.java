package Task_13;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class PageFactoryTest extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        get(LoginPage.class).open();
    }

    @Test
    public void addToShoppingCardTest() {
        get(LoginPage.class).waitUntilPageLoaded()
                .verifyPage()
                .enterUsername()
                .enterPassword()
                .clickLoginButton();
        get(ProductPage.class).verifyPage()
                .clickAddToCard(1);
        Assert.assertEquals(get(ProductPage.class).getNumberOfProductsInShoppingCard(), "1", "SomeTest didn't work");
    }

}
