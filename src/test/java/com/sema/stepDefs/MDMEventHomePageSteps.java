package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MDMEventHomePageSteps extends BaseStep {
    @Then("The User performs a mouseover on the Event Management element")
    public void the_user_performs_a_mouseover_on_the_event_management_element() {
    pages.homePage().mouseoverOnTheEventManagementElement();
    }
    @Then("The User performs a mouseover on the Event element")
    public void the_user_performs_a_mouseover_on_the_event_element() {
        pages.homePage().mouseoverOnTheEventElement();
    }
    @Then("The User clicks on the Event element")
    public void the_user_clicks_on_the_event_element() {
        pages.homePage().clicksOnTheEventElement();
    }
    @Then("The user clicks on WSET Filtre")
    public void the_user_clicks_on_wset_filtre() {
        pages.eventHomePage().selectIWSAFamilyFilter();
    }
    @Then("the user verify on family filter WSET functionality")
    public void the_user_verify_on_family_filter_wset_functionality() {
     pages.eventHomePage().verifyWSETFamilyFilter();
    }
    @Given("The user is on the Event item home page")
    public void the_user_is_on_the_event_item_home_page() {
pages.eventHomePage().onTheEventPage();
    }
    @Then("The user clicks new list item-event")
    public void the_user_clicks_new_list_item() {
        pages.eventHomePage().clickListItem();
    }
    @Given("The user clicks Associated status {string}")
    public void the_user_clicks_associated_status(String status) {
        pages.eventHomePage().selectAssociatedFilter(status);
    }

    @When("The user click event tab")
    public void theUserClickEventTab() {
        pages.eventHomePage().getCalendarTab().click();
    }

    @Then("The user verify calendar is visible")
    public void theUserVerifyCalendarIsVisible() {
//        Driver.getDriver().switchTo().frame(pages.accountHomePage().getMapFrame());
        BrowserUtils.waitForVisibility(pages.eventHomePage().getCalendarContainer(),30);
        Assert.assertTrue("Harita bulunamadı", BrowserUtils.isElementDisplayed(pages.eventHomePage().getCalendarContainer()));
    }

    @When("The user go to Calendar page")
    public void theUserGoToCalendarPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EmbedDashboardCalendar");
        BrowserUtils.wait(3);
    }

    @Then("The user verify calendar page is open")
    public void theUserVerifyCalendarPageIsOpen() {
        WebElement mainFrame = Driver.getDriver().findElement(By.xpath("//iframe[@id='general-events']"));
        Driver.getDriver().switchTo().frame(mainFrame);
        Driver.getDriver().switchTo().frame(pages.eventHomePage().getEventCalendarIframe());
        Assert.assertTrue(BrowserUtils.isElementDisplayed
                (Driver.getDriver().findElement(By.xpath("//span[text()='Etkinlikler Genel']"))));
    }
}
