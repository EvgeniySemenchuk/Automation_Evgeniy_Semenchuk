package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By productList = By.className("inventory_item");
    private final By addToCard = By.tagName("button");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");


    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Assert.assertFalse(getDriver().findElements(productList).isEmpty(), "Product list is empty.");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url.");
    }

    public void clickAddToCard(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(addToCard));
    }

    public void clickMoveToShoppingCard() {
        click(getDriver().findElement(moveToShoppingCardButton));
    }

    public String getNumberOfProductsInShoppingCard() {
        return getDriver().findElement(moveToShoppingCardButton).getText();
    }


}
