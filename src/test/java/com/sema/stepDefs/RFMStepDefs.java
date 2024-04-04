package com.sema.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RFMStepDefs extends BaseStep{
    @Given("The user is on the RFM")
    public void theUserIsOnTheRFM() {
        pages.rfm().onTheRFMPage();
    }

    @When("The user rfm page verifies")
    public void theUserRfmPageVerifies() {
        pages.rfm().rfmVerifies();
    }

    @And("The user clicks POSM button")
    public void theUserClicksPOSMButton() {
        pages.rfm().onThePOSMPage();
    }

    @And("The user verifies POSM")
    public void theUserVerifiesPOSM() {
        pages.rfm().posmVerifies();
    }
}
