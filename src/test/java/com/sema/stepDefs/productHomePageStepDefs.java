package com.sema.stepDefs;

import io.cucumber.java.en.Given;

public class productHomePageStepDefs extends BaseStep{
    public productHomePageStepDefs() {
    }
    @Given("The user is on the Product item home page")
    public void the_user_is_on_the_Product_item_home_page() {
pages.productHomePage().onTheUserPage();
    }
}
