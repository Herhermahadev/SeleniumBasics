import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    WebDriver driver;
    String baseUrl;
    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl="https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.id("bmwcheck")).click();
        System.out.println(driver.findElement(By.id("bmwcheck")).isSelected());



        driver.findElement(By.cssSelector("div[id='checkbox-example-div'] [value='benz']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[id='checkbox-example-div'] [value='benz']")).isSelected());
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected());
        Thread.sleep(2000);

        }





    @After
    public void tearDown()
    {
        driver.quit();
    }

}
