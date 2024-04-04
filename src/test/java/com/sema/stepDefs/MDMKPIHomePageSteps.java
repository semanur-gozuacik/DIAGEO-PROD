package com.sema.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.devtools.v85.page.Page;

public class MDMKPIHomePageSteps extends BaseStep {
    @Then("The User performs a mouseover on the KPI Management element")
    public void the_user_performs_a_mouseover_on_the_kpı_management_element() {
        pages.homePage().mouseoverOnTheKPIManagementElement();
    }

    @Then("The User performs a mouseover on the KPI element")
    public void the_user_performs_a_mouseover_on_the_kpı_element() {
        pages.homePage().mouseoverOnTheKPIElement();
    }

    @Then("The User clicks on the KPI element")
    public void the_user_clicks_on_the_KPI_element() {
        pages.homePage().clicksOnTheKPIElement();
    }

    @Then("The User clicks on the ROOT  element")
    public void the_user_clicks_on_the_root_element() {
        pages.kpiHomePage().clickRootElement();
    }
    @Then("The User presses the down arrow key and then presses Enter  in the {string} element")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_element(String family) {
       pages.kpiHomePage().selectKPIFamily(family);

    }
    @Given("The user is on the KPI item home page")
    public void the_user_is_on_the_kpı_item_home_page() {
pages.kpiHomePage().onTheKPIPage();
    }
}