package cucumber_rabota;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rabotaby.HomePage;
import pageObjects.rabotaby.SearchPage;

public class HomeSteps extends BaseTestSelenide {

    @Given("Open home page")
    public void precondition() {
        get(HomePage.class);
    }

    @When("I enter ${string} in search field")
    public void enterTextInSeachField(String text) {
        get(HomePage.class).enterSearch(text);
    }

    @And("I click on search button")
    public void clickSearch() {
        get(HomePage.class).clickSearch();
    }

    @Then("I verify vacancy - {string} in header")
    public void verifyHeaderText(String vacancy) {
        Assert.assertTrue(get(SearchPage.class).verifyContentOfHeader(vacancy), "Not correct text in header");
    }

    @Then("Compare number of vacancies with {int}")
    public void verifyNumberOfVacancies(Integer number) {
        Assert.assertTrue(get(SearchPage.class).verifyNumberOfVacancy(number), "Something wrong with number of vacancies");
    }
}
