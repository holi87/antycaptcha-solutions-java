package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Common;

import java.util.List;


public class LandingPage extends Common {
    public LandingPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public String getSeed() {
        logger.info("Getting seed value");
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre/code/em"))).getText();
    }


    private List<WebElement> exercisesButtons() {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='four columns']")));
    }

    public void openExerciseByName(String exerciseName) {
        logger.info("Press exercise '" + exerciseName + "' button");
        for (WebElement element : exercisesButtons()) {
            WebElement button = element.findElement(By.cssSelector("a.button"));
            if (button.getText().contains(exerciseName.toUpperCase())) {
                button.click();
                break;
            }
        }
    }

}
