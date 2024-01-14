package pageFactory.saucedemo;

import entities.saucedemo.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductPage extends BasePage implements Page {
    @FindBys({@FindBy(className = "inventory_item")})
    List<WebElement> productList;

    @FindBy(className = "app_logo")
    WebElement header;

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    @FindBy(className = "shopping_cart_link")
    WebElement moveToShoppingCardButton;

    private final By addToCard = By.tagName("button");

    public ProductPage verifyPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url.");
        return this;
    }

    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductPage clickAddToCard(Integer index) {
        click(productList.get(index).findElement(addToCard));
        return this;
    }

    public ProductPage clickMoveToShoppingCard() {
        click(moveToShoppingCardButton);
        return this;
    }

    public String getNumberOfProductsInShoppingCard() {
        return moveToShoppingCardButton.getText();
    }

    public ProductPage clickToNameOfProduct(String item) {
        wait.until(elementToBeClickable(getProductName(item)));
        click(getProductName(item));
        return this;
    }

    public ProductPage clickToNameOfProduct(Product product) {
        wait.until(elementToBeClickable(getProductName(product.getProductName())));
        click(getProductName(product.getProductName()));
        return this;
    }

    private By getProductName(String item) {
        return By.linkText(item);
    }

    @Override
    public ProductPage waitUntilPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
        return this;
    }
}
