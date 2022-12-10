package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TC_002 extends BaseTest{

    @Test
    public void TC_002(){

        HomePage hp = new HomePage(driver);
        hp.navigateToTravelInsurance(driver);
        hp.selectGeography();
        hp.setectDate("27","10");


    }
}
