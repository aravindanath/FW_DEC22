package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static String getValue(String key){
        String path = System.getProperty("user.dir")+
                File.separator+"Config.properties";
        String value = null;
        try {
            FileInputStream in = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(in);
            value =  prop.getProperty(key);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }


    public static void waitForElement(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static String getValue(String header,String key){
        String path = System.getProperty("user.dir")+
                File.separator+"Files"+File.separator+"data.ini";
        String value = null;
        try {
            FileInputStream in = new FileInputStream(path);
            Ini prop = new Ini();
            prop.load(in);
            value =  prop.get(header,key);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }


    public static void  setectByINdex(WebElement element, int index){
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }


    public static void  setectByValue(WebElement element, String value){
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public static void  setectByVisisbleText(WebElement element, String value){
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }


    public static void  desetectByINdex(WebElement element, int index){
        Select sel = new Select(element);
        sel.deselectByIndex(index);
    }


    public static void  desetectByValue(WebElement element, String value){
        Select sel = new Select(element);
        sel.deselectByValue(value);
    }

    public static void  desetectByVisisbleText(WebElement element, String value){
        Select sel = new Select(element);
        sel.deselectByVisibleText(value);
    }

    public static void  desetectALL(WebElement element){
        Select sel = new Select(element);
        sel.deselectAll();
    }


    public static String firstName(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().firstName();
        return fn;
    }


    public static String lastname(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().lastName();
        return fn;
    }
    public static String email(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().firstName().replace(" ", "")+"@testmail.com";
        return fn;
    }


    public static String mobileNumber(){
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.number().digits(10);
        return fn;
    }

    public static void scroll(WebElement element, WebDriver driver){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void acceptAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        System.out.println("Title: " + alert.getText());
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        System.out.println("Title: " + alert.getText());
        alert.dismiss();
    }
    public static void acceptAlert(WebDriver driver, String text){
        Alert alert = driver.switchTo().alert();
        System.out.println("Title: " + alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }

    public  static  void   mouseHover(WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public  static  void   click(WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }

    public  static  void   dragANDdrop(WebDriver driver,WebElement element1, WebElement element2){
        Actions act = new Actions(driver);
        act.dragAndDrop(element1,element2).build().perform();
    }
    public  static  void   rightClick(WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.contextClick(element).build().perform();
    }

    public static void takeScreenshot(WebDriver driver)  {
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver;
            File scrFile = srcShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./screenshot" + timeStamp() + ".png"));
        }catch (IOException e){

        }
    }

    public static String timeStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).replace("/","_").replace(" ","_").replace(":","_");
    }


}
