package pageObjects.saucedemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
@Log4j
public class ShoppingCardPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.name("checkout");
    private final By productList = By.className("cart_item");
    private final By removeFromCard = By.tagName("button");

    public ShoppingCardPage verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong header url.");
        return this;
    }

    public ShoppingCardPage clickContinueShoppingButton() {
        click(getDriver().findElement(continueShoppingButton));
        return this;
    }

    public ShoppingCardPage clickCheckoutButton() {
        click(getDriver().findElement(checkoutButton));
        return this;
    }

    public ShoppingCardPage clickRemoveFromCard(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(removeFromCard));
        return this;
    }

    public Integer getNumberOfProductsInShoppingCard() {
        log.info("Number products in shopping card is " + getDriver().findElements(productList).size());
        return getDriver().findElements(productList).size();
    }


}
