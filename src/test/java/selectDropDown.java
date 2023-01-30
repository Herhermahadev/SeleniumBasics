import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class selectDropDown {
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
    public void dropdownSelect() {
        driver.get(baseURL);

        WebElement elements= driver.findElement(By.id("carselect"));
        Select select = new Select(elements);
        select.selectByIndex(2);
        System.out.println(select);
        //select.selectByValue("Bmw");



    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
