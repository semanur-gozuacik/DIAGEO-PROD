package com.sema.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SystemUsersStepDef extends BaseStep{
    public SystemUsersStepDef() {}
    @Then("The User performs a mouseover on the UserManagement element")
    public void the_user_performs_a_mouseover_on_the_user_management_element() {
     pages.homePage().mouseoverOnTheUsersManagementElement();
    }
    @Then("The User performs a mouseover on the Users element")
    public void the_user_performs_a_mouseover_on_the_users_element() {
     pages.homePage().mouseoverOnTheUsersElement();
    }

    @Then("The User clicks on the Users element")
    public void the_user_clicks_on_the_users_element() {
     pages.homePage().clicksOnTheUsersElement();
    }

    @Then("The User verifies User Overview table is displayed")
    public void the_user_verifies_user_overview_table_is_displayed() {pages.users().verifyUsers();}
    @When("The user selects {string} into show entries users")
    public void the_user_selects_into_show_entries_users(String entrie) {
        pages.users().selectEntrie(entrie);
    }
    @Then("The user should see  {string} entrie in everypage users")
    public void the_user_should_see_entrie_in_everypage_users(String entrie) {
        pages.users().verifySelectOption(entrie);
    }
    @Then("The user verifies first page button is not clickable-users")
    public void the_user_verifies_first_page_button_is_not_clickable() {
        pages.users().verifyFirstPageButtonUnClickable();
    }
    @Then("The user verifies previous page button is not clickable-users")
    public void the_user_verifies_previous_page_button_is_not_clickable() {
        pages.users().verifyPreviousPageButtonUnClickable();
    }
    @When("The user clicks last page button-users")
    public void the_user_clicks_last_page_button_users() {
        pages.users().clickLastPage();
    }
    @Then("The user verifies previous page button is clickable-users")
    public void the_user_verifies_previous_page_button_is_clickable() {
        pages.users().verifyPreviousPageButtonClickable();
    }
    @When("The user verifies next button is not clickable-users")
    public void the_user_verifies_next_button_is_not_clickable_users() {
        pages.users().verifyNextPageButtonUnClickable();
    }
    @When("The user verifies last page button is not clickable-users")
    public void the_user_verifies_last_page_button_is_not_clickable_users() {
        pages.users().verifyLastPageButtonUnClickable();
    }
    @Then("The user verifies first page button is clickable-users")
    public void the_user_verifies_first_page_button_is_clickable() {
        pages.users().verifyFirstPageButtonClickable();
    }
    @When("The user verifies next button is clickable-users")
    public void the_user_verifies_next_button_is_clickable_families() {
        pages.users().verifyNextPageButtonClickable();
    }
    @When("The user verifies last page button is clickable-users")
    public void the_user_verifies_last_page_button_is_clickable_users() {
        pages.users().verifyLastPageButtonClickable();
    }
    @Then("The user enters {string} into username field")
    public void the_user_enters_into_username_field(String username) {
      pages.users().setUsernameFilter(username);
    }
    @Then("the user verify on username filter functionality {string}")
    public void the_user_verify_on_username_filter_functionality(String username) {
     pages.users().verifyUsernameFilter(username);
    }
    @Then("the user verify on username filter functionality {string}-partial username")
    public void the_user_verify_on_username_filter_functionality_partial_username(String username) {
        pages.users().verifyPartialUsernameFilters(username);
    }
    @Then("the user verify on username filter functionality {string}-invalid username")
    public void the_user_verify_on_username_filter_functionality_invalid_username(String text) {
        pages.users().verifyNoContentTextInvalidUniqueUsername(text);
    }

    @Then("The user enters {string} into userEmail field")
    public void the_user_enters_into_user_email_field(String userEmail) {
pages.users().setUserEmailFilter(userEmail);
    }
    @Then("the user verify on userEmail filter functionality {string}")
    public void the_user_verify_on_user_email_filter_functionality(String userEmail) {
        pages.users().verifyUserEmailFilter(userEmail);

    }
    @Then("The user enters {string} into first name field")
    public void the_user_enters_into_first_name_field(String firstName) {
pages.users().setFirstNameFilter(firstName);
    }

    @Then("the user verify on first name filter functionality {string}")
    public void the_user_verify_on_first_name_filter_functionality(String firstName) {
pages.users().verifyFirstNameFilter(firstName);
    }
    @Then("the user verify on username filter functionality {string}-invalid first name")
    public void the_user_verify_on_username_filter_functionality_invalid_first_name(String text) {
        pages.users().verifyNoContentTextInvalidUniqueUsername(text);
    }

    @Then("the user verify on first name filter functionality {string}-partial first name")
    public void the_user_verify_on_first_name_filter_functionality_partial_first_name(String firstName) {
        pages.users().verifyPartialFirstNameFilters(firstName);
    }
    @Then("the user verify Reset button functionality-Users")
    public void the_user_verify_reset_button_functionality_users() {
        pages.users().verifyResetButton();
    }
    @Then("The user clicks on Is Real")
    public void the_user_clicks_on_is_real() {
pages.users().clicksIsReal();
    }
    @Then("The user clicks on {string} Is Real")
    public void the_user_clicks_on_is_real(String isReal ) {
pages.users().selectIsRealFilter(isReal);
    }
    @Then("The incoming filter for {string} should contain Is Real")
    public void the_incoming_filter_for_should_contain_is_real(String isReal) {

    }
    @Given("The user on the settings users page")
    public void the_user_on_the_settings_users_page() {
pages.users().onTheUsersSettingPage();
    }
}
