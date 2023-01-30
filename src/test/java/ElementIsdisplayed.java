import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementIsdisplayed {
    WebDriver driver;
    String baseURL;

    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseURL= "https://courses.letskodeit.com/practice";
        driver.get(baseURL);

    }
    @Test
    public  void isDisplayed() throws InterruptedException {
        driver.findElement(By.id("hide-textbox")).click();
        System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
        Thread.sleep(2000);

        driver.findElement(By.id("show-textbox")).click();
        System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
        Thread.sleep(1000);


     //when its visible send keys
        if (driver.findElement(By.id("displayed-text")).isDisplayed()){
            driver.findElement(By.id("displayed-text")).sendKeys("Its cool");
        }
  Thread.sleep(1000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
