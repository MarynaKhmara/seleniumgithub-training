import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Task_4 {

    WebDriver driver_ch;
    WebDriver driver_ff;


    @Before
    public void start() {
        driver_ch = new ChromeDriver();
        driver_ch.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
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


        List<WebElement> menu = driver_ch.findElements(By.id("app-"));

        int menucount = menu.size();
        for (int i = 0; i < menucount; i++) {
            menu = driver_ch.findElements(By.id("app-"));
            WebElement menuItem = menu.get(i);
            menuItem.click();


            menu = driver_ch.findElements(By.id("app-"));
            menuItem = menu.get(i);
            List<WebElement> submenu = menuItem.findElements(By.cssSelector("[id^=doc-]"));
            int submenucount = submenu.size();
            if (submenucount > 0) {
                for (int j = 0; j < submenucount; j++) {
                    menu = driver_ch.findElements(By.id("app-"));
                    menuItem = menu.get(i);
                    submenu = menuItem.findElements(By.cssSelector("[id^=doc-]"));
                    WebElement submenuItem = submenu.get(j);
                    submenuItem.click();
                    driver_ch.findElement(By.cssSelector("h1"));
                }
            } else {
                driver_ch.findElement(By.cssSelector("h1"));
            }
        }

    }


    @After
    public void stop_ch() {
        driver_ch.quit();
    }
}
