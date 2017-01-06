package org.sri.app.stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */
public class SearchStepdef {

    @Given("^I am in duckduckgo homepage$")
    public void i_am_in_duckduckgo_homepage() {
        Assert.assertEquals(1, 1);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I should see text results$")
    public void i_should_see_text_results() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I should see \"([^\"]*)\" in page source$")
    public void i_should_see_in_page_source(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^Click on Image button$")
    public void click_on_Image_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Assert.assertEquals(1, 1);
    }

    @Then("^I should see image results$")
    public void i_should_see_image_results() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
