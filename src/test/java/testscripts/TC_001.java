package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC_001 extends BaseTest{

    @Test
    public void TC_001(){

        HomePage hp = new HomePage(driver);
        hp.navigateToTravelInsurance(driver);
        hp.selectGeography();
        hp.setectDate("27","10");
        Assert.fail("Failing..");

    }
}
