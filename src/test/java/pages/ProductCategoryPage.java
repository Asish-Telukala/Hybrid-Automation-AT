package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class ProductCategoryPage extends BrowserDriver {

 public static String productcategory_heading_xpath = "//*[@id=\"ShoeType\"]";

 public static String visibility_productCategory(){
     try {
         String actualproductcategory = driver.findElement(By.xpath(productcategory_heading_xpath)).getText();
System.out.println(actualproductcategory+" is visible");
         return actualproductcategory;
     } catch (Exception e) {
         throw new RuntimeException(e);
     }

 }


}
