package Task_8;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.Frames;
import pageObjects.herokuapp.HomePage;

import static pageObjects.herokuapp.HomePageItems.FRAMES;

public class FramesTests extends BaseTest {
    private HomePage homePage;
    private Frames frames;


    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        frames = new Frames();
        homePage.open("https://the-internet.herokuapp.com");
    }

    @Test
    public void checkTextFieldTest1() {
        homePage.clickOnItem(FRAMES);
        frames.verifyTitleText();
        frames.clickOnItem("iFrame");
        frames.switchToFrame();
        frames.verifyTextFromTextField();
        frames.unSwitchToFrame();
    }


}
