import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mappers.ClientMapper;
import model.Client;
import model.Income;

import java.util.Map;

public class ClientStepDefs {
    private Client client = new Client();
    private ClientMapper clientMapper = new ClientMapper();

    @Given("client:")
    public void set_client(Map<String, String> params) {
        client = clientMapper.mapClient(params);
    }

    @Given("income data is:")
    public void set_income_data(Map<String, String> params) {
        Income income = new Income();

        income.setAmount(Double.valueOf(params.get("amount")));
        income.setExpenses(Double.valueOf(params.get("expenses")));
        income.setEmployer(params.get("employer"));

        client.setIncome(income);
    }

    @When("checking it in ERP")
    public void get_client_from_ERP() {
        //poluchili dammie klienta iz ERP
    }

    @Then("client data is correct")
    public void check_client_data() {

    }
}
