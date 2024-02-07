package pageObjects.rw;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class SchedulePage {
    private final ElementsCollection dates = $$x("//ul[@class=\"sch-links__nav list-reset\"]//span");
    private final ElementsCollection trainRoutes = $$x("//span[@class=\"train-route\"]");
    private final ElementsCollection departuresTimes = $$x("//div[@data-sort=\"departure\"]");
    private final ElementsCollection arrivalTimes = $$x("//div[@data-sort=\"arrival\"]");
    private final ElementsCollection timeOnRoute = $$x("//span[@class=\"duration\"]");

    public SchedulePage verifyDates(String ... dates) {
        Arrays.asList(dates).forEach(date->this.dates.find(matchText(date)).should(exist));
        return this;
    }

    public SchedulePage verifyRoutes(String ... routes) {
        Arrays.asList(routes).forEach(route->this.trainRoutes.find(matchText(route)).should(exist));
        return this;
    }

    public List<String> getDates() {
        return dates.texts();
    }

    public SchedulePage clickDate(String date) {
        dates.find(matchText(date)).click();
        return this;
    }

    public List<String> getRoutesData() {
        return trainRoutes.texts();
    }

    public List<String> getDeparturesTimeData() {
        return departuresTimes.texts();
    }

    public List<String> getArrivalTimeData() {
        return arrivalTimes.texts();
    }

    public List<String> getTimeOnRouteData() {
        return timeOnRoute.texts();
    }

    public SchedulePage clickOnRoute(Integer index) {
        trainRoutes.get(index).should(visible,exist).click();
        return this;
    }

    public SchedulePage navigateBack() {
        driver().getWebDriver().navigate().back();
        return this;
    }

    public Map<String, String> getOneRouteData(Integer index) {
        Map<String, String> routeData = new HashMap<>();
        routeData.put("Route", getRoutesData().get(index));
        routeData.put("Time in route", getTimeOnRouteData().get(index));
        routeData.put("Departure time", getDeparturesTimeData().get(index));
        return routeData;
    }

    public SchedulePage getRoutesInfo() {
        for (int i = 0; i < getRoutesData().size(); i++) {
            System.out.println("ROUTE NUMBER " + (i + 1));
            for (Map.Entry route : getOneRouteData(i).entrySet()) {
                System.out.println(route);
            }
        }
        return this;
    }

}
