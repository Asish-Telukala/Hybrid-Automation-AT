package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/java/features/api_feature",  // Path to feature files
        glue = {"utility","stepdefinition/apiStepDef"},                   // Package for step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        tags = "@Smoke1",
        monochrome = true
)


public class ApiTestRunner extends AbstractTestNGCucumberTests {


}
