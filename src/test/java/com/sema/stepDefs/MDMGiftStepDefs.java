package com.sema.stepDefs;

import io.cucumber.java.en.Then;

public class MDMGiftStepDefs extends BaseStep{
    @Then("The User performs a mouseover on the Gift Management element")
    public void the_user_performs_a_mouseover_on_the_gift_management_element() {
        pages.homePage().mouseoverOnTheGiftManagementElement();
    }
    @Then("The User performs a mouseover on the Gift element")
    public void the_user_performs_a_mouseover_on_the_gift_element() {
        pages.homePage().mouseoverOnTheGiftElement();
    }

    @Then("The User clicks on the TEST element")
    public void the_user_clicks_on_the_test_element() {
        pages.gift().clickTestCategories();
    }
    @Then("The User clicks on the Gİft element")
    public void the_user_clicks_on_the_g_ift_element() {
        pages.homePage().clicksOnTheGiftElement();
    }
    @Then("The User waits until the ROOT element in the gift is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_root_element_in_the_gift_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.gift().verifyGiftRootCategories(timeout);
    }
    @Then("The User presses the down arrow key and then presses Enter in the Gift Family element")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_gift_family_element() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user clicks the {string} dropdown")
    public void the_user_clicks_the_dropdown(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user enters a XGIFT_NAME {string} input fields")
    public void the_user_enters_a_xgıft_name_input_fields(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user enters a XGIFT_PERCENT {double} input fields")
    public void the_user_enters_a_xgıft_percent_input_fields(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user enter a XGIFT_COST {double} input fiels")
    public void the_user_enter_a_xgıft_cost_input_fiels(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user enter a Start Date input {double}.{int} fiels")
    public void the_user_enter_a_start_date_input_fiels(Double double1, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user enter a And Date {double}.{int} input fiels")
    public void the_user_enter_a_and_date_input_fiels(Double double1, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

