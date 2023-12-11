package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;

public class ShoppingCardPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.name("checkout");
    private final By productList = By.className("cart_item");
    private final By removeFromCard = By.tagName("button");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong header url.");
    }

    public void clickContinueShoppingButton() {
        click(getDriver().findElement(continueShoppingButton));
    }

    public void clickCheckoutButton() {
        click(getDriver().findElement(checkoutButton));
    }

    public void clickRemoveFromCard(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(removeFromCard));
    }

    public Integer getNumberOfProductsInShoppingCard() {
        return getDriver().findElements(productList).size();
    }


}
