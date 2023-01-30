package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UpdatedDropdown {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void updatedDrop() throws InterruptedException
    {
        driver.get(baseUrl);
        driver.findElement(By.id("divpaxinfo")).click();
        //Thread.sleep(1000);
        System.out.println( driver.findElement(By.id("divpaxinfo")).getText());


//        int i = 1;
//        while (i < 5)
//        {
//            driver.findElement(By.id("hrefIncAdt")).click();  //4 times click
//            i++;
//        }

        for(int i=1 ; i<5 ; i++){
            driver.findElement(By.id("hrefIncAdt")).click();  //4 times click
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println( driver.findElement(By.id("divpaxinfo")).getText());

        Thread.sleep(2000);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

