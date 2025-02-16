package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    public static ExtentTest featureTest;
    public static ExtentTest scenarioTest;
    public static ExtentReports extent;
    public static ExtentReports uiExtent;
    public static ExtentReports apiExtent;



    public static String getDateTime(){
        return new SimpleDateFormat("yyMMdd_HHmmss").format( new Date());

    }

    public static void initializeExtentReports(String testType){

        String reportpath;
        if (testType.equalsIgnoreCase("UI")){
       reportpath = "target/uiReports/UI_ExtentReport_"+getDateTime()+".html";
       System.out.println(reportpath + "  - path to store UI report");
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportpath);
            uiExtent = new ExtentReports();
            uiExtent.attachReporter(sparkReporter);
        }
    }
    public static void startFeature(String testType,String featureName) {
        if (testType.equalsIgnoreCase("UI") && uiExtent!= null) {
//        Creates a new Feature node in Extent Reports.
            featureTest = uiExtent.createTest("Feature: " + featureName);
        }
    }
        public static void startScenario(String testType,Scenario scenario) {
//Creates a new Scenario node under the corresponding Feature.
//Scenario is nested under the feature.
            if (testType.equalsIgnoreCase("UI") && uiExtent != null) {
                scenarioTest = featureTest.createNode("Scenario: " + scenario.getName());
            }
        }

    public static void logStep(Status status, String stepDescription) {
//        Logs steps dynamically within a scenario.
        scenarioTest.log(status, stepDescription);
    }
    public static void flushExtentReports() {
        if (uiExtent != null) {
            uiExtent.flush();
        }
    }
}
