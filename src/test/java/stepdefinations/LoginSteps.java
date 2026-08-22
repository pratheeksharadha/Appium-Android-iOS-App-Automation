package stepdefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


    @Given("User launches the application")
    public void launchApplication() {
        System.out.println("launchApplication");
    }

    @When("User enters valid username")
    public void enterUsername() {
        System.out.println("enterUsername");
    }

    @When("User enters valid password")
    public void enterPassword() {
        System.out.println("enterPassword");
    }

    @When("User taps Login button")
    public void tapLogin() {
        System.out.println("tapLogin");
    }

    @Then("Products page should be displayed")
    public void verifyProductsPage() {
        System.out.println("verifyProductsPage");
    }

    @When("User logs in with {string} and {string}")
    public void userLogsInWithAnd(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        System.out.println("userLogsInWithAnd");
    }
}
