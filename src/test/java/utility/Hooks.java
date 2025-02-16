package utility;

import com.aventstack.extentreports.Status;
import io.cucumber.java.*;

public class Hooks {

    public static BrowserDriver browserDriver;

    @BeforeAll
    public static void beforeAll() {
        // Initialize Extent Reports before any tests start
//        ExtentManager.initializeExtentReports(testType);
        ExtentManager.initializeExtentReports("UI");
    }

    @Before
    public void setUp(Scenario scenario) {
TestType testType = getTestType(scenario);
String testTypeStr = testType.name();
        try {
            if (testType==TestType.UI) {
                browserDriver = new BrowserDriver();
            }

            // Start Feature and Scenario
//            ExtentManager.initializeExtentReports(testTypeStr);
            ExtentManager.startFeature(testTypeStr, getFeatureName(scenario));
            ExtentManager.startScenario(testTypeStr,scenario);
                // Log test execution start
                ExtentManager.scenarioTest.log(Status.INFO,testTypeStr+ " Scenario: " + scenario.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @After
    public void tearDown(Scenario scenario) {
        TestType testType = getTestType(scenario);
        if (testType==TestType.UI && browserDriver != null) {
                if (scenario.isFailed()) {
                    ExtentManager.scenarioTest.log(Status.FAIL, "UI Test Failed: " + scenario.getName());
                } else {
                    ExtentManager.scenarioTest.log(Status.PASS, "UI Test Passed: " + scenario.getName());
                }
                browserDriver.close();
        }
        else if (testType==TestType.API) {
            if (scenario.isFailed()) {
                ExtentManager.scenarioTest.log(Status.FAIL, "API Test Failed: " + scenario.getName());
            } else {
                ExtentManager.scenarioTest.log(Status.PASS, "API Test Passed: " + scenario.getName());
            }

        }
    }

    @AfterAll
    public static void afterAll() {
        ExtentManager.flushExtentReports();  // Flush reports only once
    }



    private enum TestType {
        UI, API, UNKNOWN
    }

    private TestType getTestType(Scenario scenario) {
        String scenarioUri = scenario.getUri().toString();

        if (scenarioUri.contains("ui_feature")) {
            return TestType.UI;
        } else if (scenarioUri.contains("api_feature")) {
            return TestType.API;
        }
        return TestType.UNKNOWN;
    }

    // Helper method to extract feature name dynamically
    private String getFeatureName(Scenario scenario) {
        String rawUri = scenario.getUri().toString();
        return rawUri.substring(rawUri.lastIndexOf('/') + 1);
    }
}
