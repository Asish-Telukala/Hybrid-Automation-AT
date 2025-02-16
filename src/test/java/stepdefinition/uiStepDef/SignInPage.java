package stepdefinition.uiStepDef;

import io.cucumber.java.en.When;

import static pages.SignInPage.*;

public class SignInPage {

    @When("^user enter login details$")
    public void user_logsin_to_login_page(){
        sendkeys_username("Asish");
        sendkeys_password("12344");
        click_login_btn();
        System.out.println("user clicked on sign in button");
    }

    @When("^user clicks new registration button$")
    public void user_clicks_new_registration_btn(){
        click_registration_btn();
    }
}
