import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchIframe {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseURL="https://courses.letskodeit.com/practice";
    }
    @Test
    public void iFrameSwitch() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(1000);
        // Switch to frame by Id
//        driver.switchTo().frame("courses-iframe");

        // Switch to frame by name
       // driver.switchTo().frame("iframe-name");

        // Switch to frame by numbers
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search Course']"));
        searchBox.sendKeys("java");
        //searchBox.click();
        searchBox.sendKeys(Keys.ENTER);

        driver.switchTo().defaultContent();
       Thread.sleep(2000);
        driver.findElement(By.id("openwindow")).click();




    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
