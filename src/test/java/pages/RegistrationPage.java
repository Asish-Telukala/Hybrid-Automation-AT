package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class RegistrationPage extends BrowserDriver {

    public static String resgistration_heading_xpath = "/html/body/center/h1";


    public static String visible_registrationheading() {
        String getRegistration = driver.findElement(By.xpath(resgistration_heading_xpath)).getText();

return getRegistration;

    }

}
