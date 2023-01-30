package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertHandle {
    WebDriver driver;
    String baseUrl;
@Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
    public void handleAlerts() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.id("name")).sendKeys("RamRam");
        driver.findElement(By.id("alertbtn")).click();

       Alert alert = driver.switchTo().alert();
       System.out.println(driver.switchTo().alert().getText());
       alert.accept();

       driver.findElement(By.id("confirmbtn")).click();
       System.out.println(driver.switchTo().alert().getText());
       alert.dismiss();


    }
@After
    public void tearDown(){
        driver.quit();
    }

}
