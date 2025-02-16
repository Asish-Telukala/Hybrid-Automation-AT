package stepdefinition.uiStepDef;

import io.cucumber.java.en.Then;

import static pages.RegistrationPage.visible_registrationheading;

public class RegistrationPage {

    @Then("^user should view registration page$")
    public void user_should_view_registration_page(){
        String getRegistration = visible_registrationheading();
    }

}
