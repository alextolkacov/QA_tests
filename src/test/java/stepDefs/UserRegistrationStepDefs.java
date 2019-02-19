package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.User;
import pages.BaseFunc;
import pages.UserRegistrationPage;

import java.io.IOException;
import java.util.Map;

public class UserRegistrationStepDefs {
    private final String URL = "http://qaguru.lv:8089/registration.php";

    private User user = new User();
    private BaseFunc baseFunc = new BaseFunc();
    private UserRegistrationPage registrationPage;
    private UserRequester userRequester = new UserRequester();

    @Given("user:")
    public void set_user(Map<String, String> params) {
        user.setPk(params.get("pk"));
        user.setName(params.get("name"));
        user.setSurname(params.get("surname"));
        user.setPhone(params.get("phone"));
        user.setEmail(params.get("email"));
    }

    @Given("registration page")
    public void open_registration_page() {
        baseFunc.goToUrl(URL);
        registrationPage = new UserRegistrationPage(baseFunc);
    }

    @When("we are registering new user")
    public void register_user() {
        registrationPage.fillInRegistrationForm(user);
    }

    @When("requesting all users list")
    public void request_users() throws IOException {
        userRequester.requestUsers();
    }

    @Then("current user is in this list")
    public void check_user() {

    }
}
