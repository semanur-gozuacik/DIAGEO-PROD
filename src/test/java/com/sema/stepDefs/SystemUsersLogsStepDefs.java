package com.sema.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SystemUsersLogsStepDefs extends BaseStep {
    public SystemUsersLogsStepDefs() {
    }
    @Given("The user on the settings users logs page")
    public void the_user_on_the_settings_users_logs_page() {
    pages.userLogs().onTheUsersSettingPage();
    }
    @Then("The User verifies User logs table is displayed")
    public void the_user_verifies_User_logs_table_is_displayed() {pages.userLogs().verifyUsers();
    }
    @Given("The user click")
    public void the_user_click() {pages.userLogs().logsClick();

    }
    @Given("The user user logs search button")
    public void the_user_user_logs_search_button() {
        pages.userLogs().logsSearhButton();
    }
    @Given("The user clicks Reset button user")
    public void the_user_clicks_reset_button_user() {


    }
    @Given("The user clicks Refresh button user")
    public void the_user_clicks_refresh_button_user() {

    }
    @Given("The user enters {string} into logs userEmail field")
    public void the_user_enters_into_logs_user_email_field(String string) {

    }
    @Given("The user enters {string} into logs result field")
    public void the_user_enters_into_logs_result_field(String string) {

    }
    @Given("The user verifies first page button is not clickable-users logs")
    public void the_user_verifies_first_page_button_is_not_clickable_users_logs() {

    }@Given("The user verifies previous page button is not clickable-users logs")
    public void the_user_verifies_previous_page_button_is_not_clickable_users_logs() {

    }@When("The user clicks last page button-users logs")
    public void the_user_clicks_last_page_button_users_logs() {

    }
    @When("The user verifies next button is not clickable-users logs")
    public void the_user_verifies_next_button_is_not_clickable_users_logs() {

    }
    @When("The user selects {string} into show entries users logs")
    public void the_user_selects_into_show_entries_users_logs(String string) {

    }
    @Then("The user should see  {string} entrie in everypage users logs")
    public void the_user_should_see_entrie_in_everypage_users_logs(String string) {

    }

}