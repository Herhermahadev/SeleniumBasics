import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioBtn {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseURL= "https://courses.letskodeit.com/practice";
    }

    @Test
    public  void radioBtnTest() throws InterruptedException {

        driver.get(baseURL);
        driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='hondaradio']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("input[id='hondaradio']")).getText());


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
