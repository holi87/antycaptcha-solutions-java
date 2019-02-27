package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Common {
    protected Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    String[] exercisesNames = {"Three buttons", "Editbox", "Dropdown list"};
    String goodAnswer = "OK. Good answer";

    @BeforeMethod
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void afterTest() {
        logger.info("Closing browser");
        driver.close();
        driver.quit();
    }

    void open(String url) {
        logger.info("Opening Antycaptcha home page");
        driver.get(url);
    }

    protected void pressButtonById(String id) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public String getSolution() {

        WebElement answerBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#trail code")));
        logger.info("Getting text from answer text area");
        return answerBox.getText();
    }

    public void pressCheckButton() {
        logger.info("Pressing check button");
        pressButtonById("solution");
    }
}

