package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicDropdown {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL="https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void dynamicDropdown() throws InterruptedException {
        driver.get(baseURL);

        //Select destination
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();       //x path by index{2}
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //parent child

        //Select calender dates from

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(1000);

        //Select the trip radios ---oneway or roundtrip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        //Select the calender dates to
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());




    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
