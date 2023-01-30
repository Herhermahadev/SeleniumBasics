package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL="https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public  void checkBox() throws InterruptedException  //country
    {
        driver.get(baseURL);
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Thread.sleep(2000);

        //count the number of checkBoxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Thread.sleep(1000);

        //Select the trip radios ---oneway or roundtrip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();


    }
    @After
    public void tearDown(){
        driver.quit();
    }

}

