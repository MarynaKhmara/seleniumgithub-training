import com.google.common.io.Files;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Task_9 {

    EventFiringWebDriver driver;


    @Before
    public void start() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new TestListener());
        driver.manage().timeouts().implicitlyWait(2 , TimeUnit.SECONDS);

        System.out.println(driver.manage().logs().getAvailableLogTypes());
    }

    @Test
    public void google_test_ch() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");


        WebElement login = driver.findElement(By.name("login"));
        login.submit();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shortcuts\"]/a[5]/i")));

        List<WebElement> menu = driver.findElements(By.xpath(".//li[@id='app-']"));

        for (int i = 0; i < menu.size(); i++) {
            WebElement menuItem = driver.findElement(By.xpath(".//li[@id='app-']["+(i+1)+"]"));
            menuItem.click();
            List<WebElement> submenu = driver.findElements(By.xpath("//li[@id='app-']["+(i+1)+"]/ul/li"));
            for (int j = 0; j < submenu.size(); j++) {
                WebElement submenuItem = driver.findElement(By.xpath(".//li[@id='app-']["+(i+1)+"]/ul/li["+(j+1)+"]"));
                submenuItem.click();
            }
        }
    }


    public static class TestListener extends AbstractWebDriverEventListener{

        @Override
        public void beforeFindBy (By by, WebElement element, WebDriver driver){
            System.out.println(by);

        }

        @Override
        public void afterFindBy (By by, WebElement element, WebDriver driver){
            System.out.println(by + "Element found");

        }

        @Override
        public void onException (Throwable throwable, WebDriver driver){
            System.out.println(throwable);
            File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(tempFile, new File( "screenimage.png"));
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }



    @After
    public void stop_ch() {
        for (LogEntry l : driver.manage().logs().get("browser").getAll()){
            System.out.println(l);
        }

        driver.quit();
    }
}
