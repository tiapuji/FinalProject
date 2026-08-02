package stepDef;

import helper.Utility;
import io.cucumber.java.*;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @Before("@web")
    public void beforeTest(){
        startDriver();
    }

    @AfterStep
    public void afterStepHook() {
        Utility.afterStep();
    }

    @After("@web")
    public void afterTest() {
        quitDriver();
    }
}
