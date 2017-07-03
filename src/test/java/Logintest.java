import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.concurrent.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Logintest {

    WebDriver driver_ch;
    WebDriver driver_ff;


    @Before
    public void start() {
        driver_ch = new ChromeDriver();
        driver_ch.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void google_test_ch() throws InterruptedException {
        driver_ch.get("http://localhost/litecart/admin/");

        WebElement username = driver_ch.findElement(By.name("username"));
        username.sendKeys("admin");


        WebElement password = driver_ch.findElement(By.name("password"));
        password.sendKeys("admin");


        WebElement  login = driver_ch.findElement(By.name("login"));
        login.submit();
    }

    @After
    public void stop_ch() {
       // driver_ch.quit();
    }




    @Before
    public void start_ff() {
        driver_ff = new FirefoxDriver();
        driver_ff.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void google_test_ff() throws InterruptedException {
        driver_ff.get("http://localhost/litecart/admin/");

        WebElement username = driver_ff.findElement(By.name("username"));
        username.sendKeys("admin");


        WebElement password = driver_ff.findElement(By.name("password"));
        password.sendKeys("admin");


        WebElement  login = driver_ff.findElement(By.name("login"));
        login.submit();


    }

    @After
    public void stop_ff() {
        //driver_ff.quit();
    }
}