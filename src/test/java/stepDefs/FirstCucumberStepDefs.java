package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseFunc;
import pages.HomePage;

import java.util.Map;

public class FirstCucumberStepDefs {
    private final String URL = "staging.koke.kz";

    private BaseFunc baseFunc = new BaseFunc();
    HomePage homePage;

    @Given("Koke home page")
    public void open_home_page() {
        baseFunc.goToUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are pressing Registration button")
    public void push_registration_btn() {
        homePage.clickGetLoan();
    }

    @Then("we are on Registration page")
    public void get_registration_page() {

    }

    @When("we are filling in registration form:")
    public void fill_form(Map<String, String> params) {

    }

    @When("we are pressing submit button")
    public void press_submit_btn() {

    }

    @Then("we are on the step2 page")
    public void get_step_two_page() {

    }
}
