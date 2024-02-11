package Task_18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"cucumber_rabota"},
        plugin = {
                "json:target/cucumber.json",
                "html:target/rabota/cucumber-pretty.html"
        },
        tags = "@regression"
)

public class RunRabotaByTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
