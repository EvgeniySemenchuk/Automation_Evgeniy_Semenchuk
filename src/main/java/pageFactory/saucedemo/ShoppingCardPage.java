package pageFactory.saucedemo;

import lombok.extern.log4j.Log4j;
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
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
@Log4j
public class ShoppingCardPage extends BasePage implements Page {

    @FindBy(className = "cart_list")
    WebElement cartList;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(name = "checkout")
    WebElement checkoutButton;

    @FindBys({@FindBy(className = "cart_item")})
    List<WebElement> productList;

    private final By removeFromCard = By.tagName("button");

    public ShoppingCardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShoppingCardPage verifyPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong header url.");
        return this;
    }

    public ShoppingCardPage clickContinueShoppingButton() {
        click(continueShoppingButton);
        return this;
    }

    public ShoppingCardPage clickCheckoutButton() {
        click(checkoutButton);
        return this;
    }

    public ShoppingCardPage clickRemoveFromCard(Integer index) {
        click(productList.get(index).findElement(removeFromCard));
        return this;
    }

    public Integer getNumberOfProductsInShoppingCard() {
        log.info("Number products in shopping card is " + productList.size());
        return productList.size();
    }

    @Override
    public ShoppingCardPage waitUntilPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(cartList));
        return this;
    }
}
