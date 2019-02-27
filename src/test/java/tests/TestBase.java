package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        driver.navigate().to(Config.url);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

