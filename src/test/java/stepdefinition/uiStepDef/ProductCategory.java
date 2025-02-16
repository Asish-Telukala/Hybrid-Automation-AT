package stepdefinition.uiStepDef;

import io.cucumber.java.en.Then;

import static pages.ProductCategoryPage.visibility_productCategory;


public class ProductCategory {

@Then("^user should view product category page$")
    public void product_category_validation() {
    String actualproductcategory = visibility_productCategory();
}
}
