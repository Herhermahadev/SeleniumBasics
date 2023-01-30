package nop_CommerceRegi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_NopComm {


    public static void main(String[] args) throws InterruptedException {

        //WITH OUT JUNIT

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());

        driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Raj");
        driver.findElement(By.name("LastName")).sendKeys("Thakur");

        WebElement staticDropdown = driver.findElement(By.name("DateOfBirthDay"));
        Select date = new Select(staticDropdown);
        date.selectByIndex(3);
        Thread.sleep(1000);
        System.out.println(date.getFirstSelectedOption().getText());

        WebElement staDropdown = driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        Select month = new Select(staDropdown);
        month.selectByIndex(7);
        Thread.sleep(1000);
        System.out.println(month.getFirstSelectedOption().getText());


        WebElement statDropdown = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Select year = new Select(statDropdown);
        year.selectByIndex(10);
        Thread.sleep(1000);
        System.out.println(year.getFirstSelectedOption().getText());



        //driver.quit();

        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);




    }
}
