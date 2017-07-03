import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;


/**
 * Created by MariBori on 6/22/17.
 */
public class Task_8 {

    WebDriver driver_ch;


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


        WebElement login = driver_ch.findElement(By.name("login"));
        login.submit();

        List<WebElement> leftMenu = driver_ch.findElements(By.cssSelector("#app-"));
        leftMenu.get(2).click();

        driver_ch.findElement(By.xpath("//*[@id=\"main\"]/ul")).click();


        List<WebElement> icons = driver_ch.findElements(By.cssSelector(".fa.fa-external-link"));
        int iconCount = icons.size();
        for (int i = 0; i < iconCount; i++) {
            icons = driver_ch.findElements(By.cssSelector(".fa.fa-external-link"));
            WebElement iconItem = icons.get(i);
            iconItem.click();

        }


        String mainWindow = driver_ch.getWindowHandle();
        Set<String> existWindows = driver_ch.getWindowHandles();

        public ExpectedCondition<String> anyWindowOtherThan (Set < String > existWindows) {

            return new ExpectedCondition<String>() {

                public String apply(WebDriver input) {

                    Set<String> handles = driver_ch.getWindowHandles();

                    handles.removeAll(existWindows);

                    return handles.size() > 0 ? handles.iterator().next() : null;

                }

            };

        }
    }

    @After
    public void stop_ch() {
        driver_ch.quit();
    }

}
