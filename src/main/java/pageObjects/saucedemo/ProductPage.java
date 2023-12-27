package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By productList = By.className("inventory_item");
    private final By addToCard = By.tagName("button");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");
    private final By productName = By.className("inventory_item_name");


    public void verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        wait.until(visibilityOfElementLocated(productList));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url.");
    }

    public void clickAddToCard(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(addToCard));
    }

    private By getProductName(String item) {
        return By.linkText(item);
    }
    public void clickToNameOfProduct(String item) {
        wait.until(elementToBeClickable(getProductName(item)));
        click(getProductName(item));
    }

    public void clickMoveToShoppingCard() {
        click(getDriver().findElement(moveToShoppingCardButton));
    }

    public String getNumberOfProductsInShoppingCard() {
        return getDriver().findElement(moveToShoppingCardButton).getText();
    }


}
