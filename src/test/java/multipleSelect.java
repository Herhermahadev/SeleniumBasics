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

public class multipleSelect {
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
    public void multiSelect() throws InterruptedException {
        driver.get(baseUrl);
        WebElement element= driver.findElement(By.id("multiple-select-example"));
        Select select=new Select(element);

        select.selectByIndex(0);
        Thread.sleep(2000);

        select.selectByIndex(1);
        Thread.sleep(1000);

        select.selectByIndex(2);
        Thread.sleep(1000);

        select.deselectByIndex(1);
        Thread.sleep(2000);

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement options: selectedOptions) {
            System.out.println(options.getText());

        }



    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
