package testngUtils;

import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestListener;

import static propertyUtils.PropertyReader.setUpProperty;
@Log4j
public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        if (System.getProperties().containsKey("config")) {
            setUpProperty(System.getProperty("config"));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Hello i'am finished with ::" + context.getSuite().getName());
    }

}
