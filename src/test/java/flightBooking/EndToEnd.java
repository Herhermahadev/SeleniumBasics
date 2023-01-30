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

public class EndToEnd {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl  = "https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void automationEnd2End() throws InterruptedException {
        driver.get(baseUrl);

        // select OneWay
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        //select destination from
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        //select destination to
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();       //x path by index{2}
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //parent child

         // select calender from
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(1000);

        //Select the trip radios --- roundtrip
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        // select passenger
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        for(int i=1 ; i<5 ; i++){
            driver.findElement(By.id("hrefIncAdt")).click();  //4 times click
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println( driver.findElement(By.id("divpaxinfo")).getText());

        Thread.sleep(2000);

         // select currency dropdown
        WebElement staticDropDown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown =new Select(staticDropDown);
        dropDown.selectByIndex(3);
        System.out.println( dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("AED");
        System.out.println( dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("INR");
        System.out.println( dropDown.getFirstSelectedOption().getText());


        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Thread.sleep(2000);

        //to hit search button
        //driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}