package utility;


import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utility.ExtentManager.extent;

public class BrowserDriver {
    public static WebDriver driver;
    public static ChromeOptions options;

//    public static ExtentTest featureTest;
//    public static ExtentTest scenarioTest;
//   public static ExtentReports extent = new ExtentReports();
//
//    public static void initializeExtentReports() {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark.html");
//        extent.attachReporter(sparkReporter);
//    }
//
//    public static void startFeature(String featureName) {
////        Creates a new Feature node in Extent Reports.
//        featureTest = extent.createTest("Feature: " + featureName);
//    }
//
//    public static void startScenario(Scenario scenario) {
////Creates a new Scenario node under the corresponding Feature.
////Scenario is nested under the feature.
//       scenarioTest = featureTest.createNode("Scenario: " + scenario.getName());
//    }
//    public static void logStep(Status status, String stepDescription) {
////        Logs steps dynamically within a scenario.
//        scenarioTest.log(status, stepDescription);
//    }
//    public static void flushExtentReports() {
//        extent.flush();
//    }

    public BrowserDriver(){
        // Initialize Chrome Options
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        System.out.println("Browser launched");

    }



    public void close(){
if (driver!= null) {
    driver.quit(); // Properly quit the browser session
    // Save report data to Spark.html
}
    }

    public WebDriver getDriver() {
        return driver;
    }
}
