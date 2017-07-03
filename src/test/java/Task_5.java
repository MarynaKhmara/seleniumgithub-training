import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task_5 {

    WebDriver driver_ch;


    @Before
    public void start() {
        driver_ch = new ChromeDriver();
        driver_ch.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void google_test_ch() throws InterruptedException {
        driver_ch.get("http://localhost/litecart/");

        WebElement duck = driver_ch.findElement(By.xpath("//*[@id=\"box-campaign-products\"]/div/div/div/a/div[2]/div[1]"));
        duck.click();


        WebElement yellow_duck = driver_ch.findElement(By.xpath("//*[@id=\"box-product\"]/div[1]/div[2]/h1"));
        Assert.assertEquals(duck, yellow_duck);
    }


    @After
    public void stop_ff() {
        driver_ch.quit();
    }
}
