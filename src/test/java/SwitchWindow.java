import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {

    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";

@Before
    public void setUp()
{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@Test
    public void windowSwitch() throws InterruptedException {

        String parentWindowHandle = driver.getWindowHandle();  //one window
        System.out.println(parentWindowHandle);

        driver.findElement(By.id("openwindow")).click();
        Set <String> handles = driver.getWindowHandles(); // more then one window
        System.out.println(handles);
        Thread.sleep(2000);


    for (String handle:handles)
    {
        System.out.println(handle);
        if (!handle.equals(parentWindowHandle))
        {
            driver.switchTo().window(handle);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
            Thread.sleep(4000);
            driver.close();
            break;
        }
    }
    Thread.sleep(2000);

     driver.switchTo().window(parentWindowHandle);

     driver.findElement(By.id("name")).sendKeys("Raj Christ");
    Thread.sleep(2000);


}
@After
    public void tearDown()
{
        driver.quit();
    }
}
