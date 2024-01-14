package Task_12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTests extends BaseTest {

    @Test
    public void streamApiTest() {
        List<Integer> list = Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> resultList = list.stream().map(x->Math.abs(x)).sorted().collect(Collectors.toList());
        System.out.println("Result list - " + resultList);
    }


}
