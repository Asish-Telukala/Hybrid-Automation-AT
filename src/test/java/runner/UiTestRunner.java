package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/ui_feature",
        glue ={"utility","stepdefinition/uiStepDef"},
        plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
        tags = "@Regression",
        monochrome = true
)



public class UiTestRunner extends AbstractTestNGCucumberTests {


}

