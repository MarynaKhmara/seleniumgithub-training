import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Task_4 {

    WebDriver driver_ch;



    @Before
    public void start() {
        driver_ch = new ChromeDriver();
        driver_ch.manage().timeouts().implicitlyWait(2 , TimeUnit.SECONDS);
    }

    @Test
    public void google_test_ch() throws InterruptedException {
        driver_ch.get("http://localhost/litecart/admin/");

        WebElement username = driver_ch.findElement(By.name("username"));
        username.sendKeys("admin");


        WebElement password = driver_ch.findElement(By.name("password"));
        password.sendKeys("admin");


        WebElement login = driver_ch.findElement(By.name("login"));
        login.submit();
        WebDriverWait wait = new WebDriverWait(driver_ch, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shortcuts\"]/a[5]/i")));

        List<WebElement> menu = driver_ch.findElements(By.xpath(".//li[@id='app-']"));

        for (int i = 0; i < menu.size(); i++) {
            WebElement menuItem = driver_ch.findElement(By.xpath(".//li[@id='app-']["+(i+1)+"]"));
            menuItem.click();
            Assert.assertTrue("H1 element not found", isElementPresent(By.cssSelector("h1")));
            List<WebElement> submenu = driver_ch.findElements(By.xpath("//li[@id='app-']["+(i+1)+"]/ul/li"));
                for (int j = 0; j < submenu.size(); j++) {
                    WebElement submenuItem = driver_ch.findElement(By.xpath(".//li[@id='app-']["+(i+1)+"]/ul/li["+(j+1)+"]"));
                    submenuItem.click();
                    Assert.assertTrue("H1 element not found", isElementPresent(By.cssSelector("h1")));
                }
            }
        Assert.assertTrue("H1 element not found", isElementPresent(By.cssSelector("h1")));
            }

    private boolean isElementPresent(By h1) {
        return driver_ch.findElements(h1).size() > 0;
    }


    @After
    public void stop_ch() {

        driver_ch.quit();
    }
}
