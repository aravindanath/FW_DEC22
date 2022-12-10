package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testscripts.BaseTest;

import java.util.List;

public class HomePage extends  BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='qf-switcher active']")
    public WebElement healthButton;

    @FindBy(xpath = "(//a[@class='qf-switcher'])[4]")
    public WebElement travelButton;

    @FindBy(xpath = "//input[@ng-show='travelCtrl.isGeographyTabSelected']")
    public WebElement geographyTab;

    @FindBy(xpath = "//a[text()='Country']")
    public WebElement countryListButton;

    @FindBy(xpath = "//div[@class='popular-countrylist']/ul/li")
    public List<WebElement> countryList;

    @FindBy(xpath = "//div[@class='doneBtn']")
    public WebElement doneButton;

    @FindBy(xpath = "(//div[@class='pika-lendar'])[1]/table/tbody/tr/td")
    public List<WebElement> fromCalendar;

    @FindBy(xpath = "(//div[@class='pika-lendar'])[4]/table/tbody/tr/td")
    public List<WebElement> toCalendar;

    @FindBy(xpath = "//button[@id='getQuoteCarWithReg']")
    public WebElement getQuoteButton;



    public void navigateToTravelInsurance(WebDriver driver){
        BasePage.click(driver,travelButton);
    }


    public void selectGeography(){
        geographyTab.click();
        countryListButton.click();
        for(WebElement country : countryList){
            System.out.println(country.getText());
            country.click();
        }
        doneButton.click();


    }

    public void setectDate(String fromDt, String toDt){
        BasePage.waitForElement(3000);
        for(WebElement fromCal : fromCalendar){
            if(fromCal.getText().equals(fromDt)){
                System.out.println(fromDt);
                BasePage.click(driver,fromCal);
                break;
            }
        }
        BasePage.waitForElement(3000);
        for(WebElement toCal : toCalendar){
            if(toCal.getText().equals(toDt)){
                System.out.println(fromDt);
                BasePage.click(driver,toCal);
                break;
            }
        }

        BasePage.click(driver,getQuoteButton);
    }



}
