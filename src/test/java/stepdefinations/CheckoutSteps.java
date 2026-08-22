package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    @When("User enters checkout details")
    public void enterDetails(DataTable dataTable) {

        System.out.println("enterDetails stepDefination");
    }
}
