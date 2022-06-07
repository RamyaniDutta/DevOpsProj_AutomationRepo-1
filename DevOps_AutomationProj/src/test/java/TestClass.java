import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestClass {

    String url;
    WebDriver driver;

    @Parameters({"url"})
    @BeforeClass
    public void init(String URLpath){
        url=URLpath;

        ChromeOptions options=new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(url);

    }

    @Test
    public void Test1(){

        String act_Text=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(act_Text,"DevOps Project");
    }
}
