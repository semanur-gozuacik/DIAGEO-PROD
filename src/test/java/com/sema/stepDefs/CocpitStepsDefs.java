package com.sema.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CocpitStepsDefs extends BaseStep{
    @Then("The User waits until the Analysis element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_analysis_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.cocpit().verifyAnalysisElement(timeout);
    }
    @Given("The user is on the Analysis cocpit")
    public void the_user_is_on_the_analysis_cocpit() {
pages.cocpit().onTheCocpitPage();
    }

    @When("The user cocpit page verifies")
    public void the_user_cocpit_page_verifies() {
pages.cocpit().overviewVerifies();
    }
    @When("The user network page verifies")
    public void the_user_network_page_verifies() {
        pages.cocpit().clicksAndVerifiesNetwork();
    }
    @When("The user call center page verifies")
    public void the_user_call_center_page_verifies() {
        pages.cocpit().clicksAndVerifiesCallCenter();
    }
    @When("The user marketing page verifies")
    public void the_user_marketing_page_verifies() {
pages.cocpit().clicksAndVerifiesMarketing();
    }
    @When("The user details page verifies")
    public void the_user_details_page_verifies() {
        pages.cocpit().clicksAndVerifiesDetails();
    }

   
}
