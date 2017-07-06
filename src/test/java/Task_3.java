import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;


public class Task_3 {

    private WebDriver driver;
    String baseUrl = "http://google.com";

    @BeforeClass
    public static void setup() {
        FirefoxDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupdriver() throws Exception {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }


        @Test
        public void google_test() throws Exception {
                driver.get(baseUrl);
            }


        @After
        public void stop() throws Exception {
            if ( driver != null) {
                driver.quit();
            }

        }
    }
