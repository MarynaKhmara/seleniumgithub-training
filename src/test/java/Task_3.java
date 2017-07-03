import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Task_3 {

    WebDriver driver1;
    WebDriver driver2;

    @Before
    public void start(){
        driver1 = new FirefoxDriver();
    }

    @Test
    public void google_test()throws InterruptedException{
        driver1.get("http://google.com");
        Thread.sleep(3000);
    }

    @After
    public void stop(){
        driver1.quit();
    }

    @Before
    public void start_browser(){
        driver2 = new ChromeDriver();
    }

    @Test
    public void googletest()throws InterruptedException{
        driver2.get("http://google.com");
        Thread.sleep(3000);
    }

    @After
    public void stop_browser(){
        driver2.quit();

    }
}