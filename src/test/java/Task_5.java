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
    String MainPage = "http://localhost/litecart/";


    @Before
    public void start() {
        driver_ch = new ChromeDriver();
        driver_ch.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void google_test_ch() throws InterruptedException {
        driver_ch.get(MainPage);


        //Verify product name
        WebElement mainName = driver_ch.findElement(By.cssSelector("a.link"));
        String productName1 = mainName.findElement(By.cssSelector(".name")).getText();
        String regularMainPrice = driver_ch.findElement(By.cssSelector(".regular-price")).getText();
        String regularGrayPrice = driver_ch.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String regularStrikePrice = driver_ch.findElement(By.cssSelector(".regular-price")).getCssValue("strike");

        String campaignMainPrice = driver_ch.findElement(By.cssSelector(".campaign-price")).getText();
        String redColorMainCampaign = driver_ch.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String boldMainCampaign = driver_ch.findElement(By.cssSelector(".campaign-price")).getCssValue("text-decoration");

        mainName.click();


        WebElement itemName = driver_ch.findElement(By.cssSelector("[id=box-product]"));
        String productName2 = itemName.findElement(By.cssSelector(".title")).getText();
        String regularItemPrice = driver_ch.findElement(By.cssSelector(".regular-price")).getText();
        String regularItemGrayPrice = driver_ch.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String regularItemStrikePrice = driver_ch.findElement(By.cssSelector(".campaign-price")).getCssValue("strike");

        String campaignItemPrice = driver_ch.findElement(By.cssSelector(".campaign-price")).getText();
        String redColorBoldCampaign = driver_ch.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String itemBoldCampaign = driver_ch.findElement(By.cssSelector(".campaign-price")).getCssValue("text-decoration");


        Assert.assertEquals(productName1, productName2);
        Assert.assertEquals(regularMainPrice, regularItemPrice);
        Assert.assertEquals(regularGrayPrice, regularItemGrayPrice);
        Assert.assertEquals(regularStrikePrice, regularItemStrikePrice);
        Assert.assertEquals(campaignMainPrice, campaignItemPrice);
        Assert.assertEquals(redColorMainCampaign, redColorBoldCampaign);
        Assert.assertEquals(boldMainCampaign, itemBoldCampaign);

    }


    @After
    public void stop() {

        driver_ch.quit();

    }

}


