package com.sema.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsImportStepDefs extends BaseStep{
    @Given("The user on the settings ımport page")
    public void the_user_on_the_settings_families_page() {
pages.importPage().onTheImportSettingPage();
    }

    @And("The user accepts the popup OK")
    public void theUserAcceptsThePopupOK() {
pages.importPage().setPopUpElement();
    }
    @Then("The User verifies import page table is displayed")
    public void the_user_verifies_import_page_table_is_displayed() {
        pages.importPage().verifyImportPage();
    }
    @When("The user selects {string} into show entries import")
    public void the_user_selects_into_show_entries_import(String string) {

    }
    @Then("The user should see  {string} entrie in everypage import")
    public void the_user_should_see_entrie_in_everypage_import(String string) {

    }
    @Given("the user clicks on Refresh button")
    public void the_user_clicks_on_refresh_button() {

    }
    @Given("The user clicks name button")
    public void the_user_clicks_name_button() {

    }
    @Given("The user {string} code field")
    public void the_user_code_field(String string) {

    }
    @Given("The user verifies name filter")
    public void the_user_verifies_name_filter() {

    }
    @When("The user selects {string} into select status")
    public void the_user_selects_into_select_status(String string) {

    }
    @Then("The user should see  {string}  import select status")
    public void the_user_should_see_import_select_status(String string) {

    }
    @Given("The user clicks user button")
    public void the_user_clicks_user_button() {

    }
    @Given("The user {string} user field")
    public void the_user_user_field(String string) {

    }
    @Given("The user verifies user filter")
    public void the_user_verifies_user_filter() {

    }
    @Given("The user clicks username button")
    public void the_user_clicks_username_button() {

    }
    @Given("The user {string} username field")
    public void the_user_username_field(String string) {

    }
    @Given("The user verifies username filter import")
    public void the_user_verifies_username_filter_import() {

    }



}
