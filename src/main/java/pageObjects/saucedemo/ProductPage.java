package pageObjects.saucedemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
@Log4j
public class ProductPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By productList = By.className("inventory_item");
    private final By addToCard = By.tagName("button");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");
    private final By productName = By.className("inventory_item_name");


    public ProductPage verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        wait.until(visibilityOfElementLocated(productList));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url.");
        return this;
    }


    public ProductPage clickAddToCard(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(addToCard));
        return this;
    }

    private By getProductName(String item) {
        return By.linkText(item);
    }
    public ProductPage clickToNameOfProduct(String item) {
        wait.until(elementToBeClickable(getProductName(item)));
        click(getProductName(item));
        return this;
    }

    public ProductPage clickMoveToShoppingCard() {
        click(getDriver().findElement(moveToShoppingCardButton));
        return this;
    }

    public String getNumberOfProductsInShoppingCard() {
        log.info("Number of products in shopping card is " + getDriver().findElement(moveToShoppingCardButton).getText());
        return getDriver().findElement(moveToShoppingCardButton).getText();
    }


}
