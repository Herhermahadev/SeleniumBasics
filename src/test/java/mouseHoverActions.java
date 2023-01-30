import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class mouseHoverActions {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl="https://courses.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
    public void hoverMouse() throws InterruptedException {
        driver.get(baseUrl);

        WebElement mainElement= driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();

        Thread.sleep(2000);

    WebElement subElement = driver.findElement(By.xpath("//a[text()='Top']"));
    action.moveToElement(subElement).click().perform();

    Thread.sleep(2000);


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
