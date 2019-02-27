package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Common;

import java.util.List;

public class Exercises extends Common {
    public Exercises(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    private List<WebElement> getListOfGoals() {
        logger.info("Getting list of buttons to press");
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.row > code")));
    }

    // dopóki mamy dwa buttony, potem trzeba się zabawić
    private void pressB1() {
        logger.info("Pressing B1 button");
        pressButtonById("btnButton1");
    }

    private void pressB2() {
        logger.info("Pressing B2 button");
        pressButtonById("btnButton2");
    }

    public void pressAllButtonsByGoals() {
        for (WebElement goal : getListOfGoals()) {
            logger.info("Need to press: " + goal.getText());
            if (goal.getText().equals("B1")) {
                pressB1();
            } else {
                pressB2();
            }
        }
    }
}
