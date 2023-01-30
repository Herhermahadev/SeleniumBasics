package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class StaticDropDown {
     WebDriver driver;
     String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL="https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sta_Drop()
    {
        driver.get(baseURL);

        WebElement staticDropDown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select  dropDown =new Select(staticDropDown);

        dropDown.selectByIndex(3);
        System.out.println( dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("AED");
        System.out.println( dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("INR");
        System.out.println( dropDown.getFirstSelectedOption().getText());

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}