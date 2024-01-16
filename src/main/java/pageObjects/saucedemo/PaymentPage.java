package pageObjects.saucedemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
@Log4j
public class PaymentPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");
    private final By productList = By.className("cart_item");
    private final By quantityOfProduct = By.xpath("//div[@class='cart_quantity']");
    private final By priceOfProduct = By.className("inventory_item_price");
    private final By totalPrice = By.xpath("//div[@class='summary_info_label summary_total_label']");
    private final By cancelButton = By.id("cancel");
    private final By finishPaymentButton = By.id("finish");
    private final By amountOfTax = By.className("summary_tax_label");

    public PaymentPage verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        wait.until(visibilityOfElementLocated(productList));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Wrong header url.");
        return this;
    }

    public PaymentPage clickCancelButton() {
        click(cancelButton);
        return this;
    }

    public PaymentPage clickFinishPaymentButton() {
        click(finishPaymentButton);
        return this;
    }

    public PaymentPage clickMoveToShoppingCardButton() {
        click(moveToShoppingCardButton);
        return this;
    }

    public String getQuantityOfProduct(Integer index) {
        log.info("Quantity of product is " + getDriver().findElements(productList).get(index).findElement(quantityOfProduct).getText());
        return getDriver().findElements(productList).get(index).findElement(quantityOfProduct).getText();
    }

    public String getPriceOfProduct(Integer index) {
        log.info("Price of product is " + getDriver().findElements(productList).get(index).findElement(priceOfProduct).getText());
        return getDriver().findElements(productList).get(index).findElement(priceOfProduct).getText();
    }

    public String getTotalPriceShowedOnPage() {
        log.info("Total price on page " + getDriver().findElement(totalPrice).getText().substring(8));
        return getDriver().findElement(totalPrice).getText().substring(8);
    }

    public String getAmountOfTax() {
        log.info("Amount of tax is " + getDriver().findElement(amountOfTax).getText().substring(6));
        return getDriver().findElement(amountOfTax).getText().substring(6);
    }


}
