package pages;

import org.openqa.selenium.By;

import static utility.BrowserDriver.driver;

public class SignInPage {

    public static String username_test_xpath = "//*[@id=\"usr\"]";
    public static String password_test_xpath = "//*[@id=\"pwd\"]";
    public static String login_btn_xpath = "//*[@id=\"second_form\"]/input";
    public static String registration_btn_xpath = "//*[@id=\"NewRegistration\"]";


    public static void sendkeys_username(String userName){
        driver.findElement(By.xpath(username_test_xpath)).sendKeys(userName);

    }

    public static void sendkeys_password(String password){

        driver.findElement(By.xpath(password_test_xpath)).sendKeys(password);

    }

    public static void  click_login_btn(){

        driver.findElement(By.xpath(login_btn_xpath)).click();
    }

    public static void click_registration_btn(){
        driver.findElement(By.xpath(registration_btn_xpath)).click();
    }
}
