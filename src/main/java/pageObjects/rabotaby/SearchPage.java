package pageObjects.rabotaby;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class SearchPage {

    private final SelenideElement header = $x("//h1");
    private final SelenideElement header2 = $x("//span[@data-qa=\"vacancies-total-found\"]//span");

    private String getHeaderText() {
        return this.header.text();
    }

    private String getHeader2Text() {
        return this.header2.text();
    }

    private Integer getQuantityOfVacancies (){
        String number = "";
        for (int i = 0; i < getHeader2Text().length(); i++) {
            if(Character.isDigit(getHeader2Text().charAt(i))) {
                number = number + getHeader2Text().charAt(i);
            }
        }
        return Integer.parseInt(number);
    }

    public Boolean verifyContentOfHeader(String vacancy) {
        return getHeaderText().contains(vacancy);
    }

    public Boolean verifyNumberOfVacancy(Integer compareNumber) {
        return getQuantityOfVacancies() > compareNumber;
    }




}
