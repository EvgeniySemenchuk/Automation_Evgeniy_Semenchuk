package Task_8;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.Frames;
import pageObjects.herokuapp.HomePage;

import static pageObjects.herokuapp.HomePageItems.DYNAMIC_CONTROLS;
import static pageObjects.herokuapp.HomePageItems.FRAMES;

public class DynamicControlTests extends BaseTest {

    private HomePage homePage;
    private DynamicControlsPage dynamicControlsPage;


    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        dynamicControlsPage = new DynamicControlsPage();
        homePage.open("https://the-internet.herokuapp.com");
    }

    @Test
    public void checkBoxTest1() {
        homePage.clickOnItem(DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyTitleText();
        dynamicControlsPage.clickRemoveOrAddButton();
        dynamicControlsPage.verifyTextAfterRemovingCheckBox();
        dynamicControlsPage.verifyRemovingCheckBox();
        dynamicControlsPage.verifyInput(false);
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.verifyTurningOnInput();
        dynamicControlsPage.verifyInput(true);
    }

}
