package testscripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class FailedRunner {


    public static void main(String[] args) {

        TestNG testscripts = new TestNG();

        List<String> suites = new ArrayList<String>();
        suites.add("/Users/aravindanathdm/Documents/PiplineDemo/POM_Fw_Dec22/test-output/Regression/testng-failed.xml");
        testscripts.setTestSuites(suites);
        testscripts.run();
    }
}
