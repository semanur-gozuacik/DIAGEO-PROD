package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsAttributesStepDefs extends BaseStep{

    public SettingsAttributesStepDefs() {   }
        @Then("The User clicks on the Attributes element")
        public void the_user_clicks_on_the_Attributes_element() {
        pages.attributes().clickAttributeElement();
        }
    @Then("The User verifies Attributes page table is displayed")
    public void the_user_verifies_attributes_page_table_is_displayed() {
    pages.attributes().verifyFamilyPage();
    }
    @Then("The user clicks on Edit Button-Attributes")
    public void the_user_clicks_on_edit_button_attributes() {
      pages.attributes().clickEditButton();
    }
    @When("The user selects {string} into show entries attributes")
    public void the_user_selects_into_show_entries_attributes(String entrie) {
        pages.attributes().selectEntrie(entrie);
    }
    @Then("The user should see  {string} entrie in everypage attributes")
    public void the_user_should_see_entrie_in_everypage_attributes(String entrie) {
        pages.attributes().verifySelectOption(entrie);
    }

    @Given("The user on the settings attribute page")
    public void the_user_on_the_settings_attribute_page() {
    pages.attributes().onTheAttributeSettingPage();
    }
    @Then("The user export button attributes")
    public void the_user_export_button_attributes() {

    }@Then("The user  {string}")
    public void the_user(String string) {

    }
}

