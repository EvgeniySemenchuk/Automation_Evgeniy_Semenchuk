package Task_12;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.HomePageItems;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;

import static pageObjects.herokuapp.HomePageItems.SORTABLE_DATA_TABLES;

public class SortableDataTablesTests extends BaseTest {

    private HomePage homePage;
    private SortableDataTablesPage tablesPage;

    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        tablesPage = new SortableDataTablesPage();
        homePage.open();
        homePage.clickOnItem(SORTABLE_DATA_TABLES);
    }

    @Test(priority = 1)
    public void emailChangesTest() {
        List<String> email = tablesPage.getConvertedEmails(1);
        System.out.println(email);
    }


}
