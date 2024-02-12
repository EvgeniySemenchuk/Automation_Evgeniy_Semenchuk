package pageObjects.rabotaby;

;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class HomePage {

    private final SelenideElement searchField = $("#a11y-search-input");
    private final SelenideElement searchButton = $x("//button[@data-qa = \"search-button\"]");

    public HomePage enterSearch(String text) {
        this.searchField.shouldBe(exist,visible).clear();
        this.searchField.sendKeys(text);
        return this;
    }

    public HomePage clickSearch() {
        this.searchButton.shouldBe(exist,visible).click();
        return this;
    }


}
