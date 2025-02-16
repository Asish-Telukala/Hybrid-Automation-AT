package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.ExtentManager;

import static utility.BrowserDriver.driver;

public class HomePage {

    public static String hamburger_menu_xpath ="//*[@id=\"menuToggle\"]/input";
    public static String signin_link_xpath = "//*[@id=\"menuToggle\"]/ul/a[2]";
    static WebElement addelement = driver.findElement(By.id("menu"));

static Actions actions = new Actions(driver);

    public static void click_hamburger_menu () throws InterruptedException {
       try {
           Thread.sleep(2000);
           driver.findElement(By.xpath(hamburger_menu_xpath)).click();
           actions.contextClick(addelement);
           ExtentManager.logStep(Status.PASS, "User click the hamburger menu");
           System.out.println("User click the hamburger menu");

       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }


    }

    public static void click_signIn_Link() throws InterruptedException {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath(signin_link_xpath)).click();
            ExtentManager.logStep(Status.PASS,"user clicks on signin button");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
