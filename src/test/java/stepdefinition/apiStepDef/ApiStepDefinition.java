package stepdefinition.apiStepDef;


import base.ApiFunctions;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ExtentManager;


public class ApiStepDefinition {

//public Ab_Api ApiKeys;

private static ApiFunctions ApiKeys = new ApiFunctions();

//    public ApiStepDefinition() {
//
//        this.ApiKeys = new ApiFunctions(); // Ensure initialization
//    }




    @Given("I hit the product {string}")
    public void iHitTheProduct(String endPoint) {
        System.out.println("endpoint = "+ endPoint);

        ApiKeys.endPointUrl(endPoint);  // Use the method to set the endpoint URL
        ExtentManager.logStep(Status.PASS, endPoint + " - endpoint is received");
    }

    @When("send {string} request")
    public void sendRequest(String hitRequest) {
    ApiKeys.hitRequestApi(hitRequest);
    }


    @Then("validate the response code {string}")
    public void validateTheResponseCode(String responseCode) {
    ApiKeys.validateResponseCode(responseCode);
    }


}
