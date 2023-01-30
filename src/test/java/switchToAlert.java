import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.Credentials;

import java.util.concurrent.TimeUnit;

public class switchToAlert {
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
    public void switchAlert() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("JamesBond007");
        //driver.findElement(By.id("alertbtn")).click();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);

        Alert alert= driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
        Thread.sleep(2000);


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
