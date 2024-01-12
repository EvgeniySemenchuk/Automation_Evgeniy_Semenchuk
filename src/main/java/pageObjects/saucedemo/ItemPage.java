package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class ItemPage extends BasePage {

    private final By addButton = By.xpath("//div[@class='inventory_details']//button");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");

    public ItemPage clickAddButton() {
        click(addButton);
        return this;
    }

    public ItemPage moveToShoppingCard() {
        click(moveToShoppingCardButton);
        return this;
    }
}
