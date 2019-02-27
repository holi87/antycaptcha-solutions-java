package tests;


import org.testng.annotations.Test;
import pages.Exercises;
import pages.LandingPage;


public class ExercisesPositiveTests extends Common {


    @Test
    public void exercise1() {
        LandingPage landingPage = new LandingPage(driver, webDriverWait);
        Exercises exercises = new Exercises(driver, webDriverWait);

        open(Config.url);
        landingPage.openExerciseByName(exercisesNames[0]);
        exercises.pressAllButtonsByGoals();
        exercises.pressCheckButton();
        logger.info(goodAnswer);
        assert exercises.getSolution().equals(goodAnswer);


    }

    @Test
    public void exercise2() {

    }

    @Test
    public void exercise3() {

    }
}
