package flightBooking;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutosuggestiveDropdown {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL="https://rahulshettyacademy.com/dropdownsPractise/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@Test
    public  void autoSuggestDropdown() throws InterruptedException  //country
    {
        driver.get(baseURL);
        driver.findElement(By.id("autosuggest")).sendKeys("Unit");
        Thread.sleep(2000);

        //To select all the element present when type Unit

       List<WebElement> options =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement country:options
             ) {
       if  (country.getText().equalsIgnoreCase("United Kingdom (UK)"))
            {
           country.click();
           break;
            }
       Thread.sleep(2000);

        }

    }
@After
    public void tearDown(){
        driver.quit();
    }

}
