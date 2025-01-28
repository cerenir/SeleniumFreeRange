package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaLogin;

public class LoginSteps {

    PaginaLogin paginaLogin = new PaginaLogin();

    @Given("I navigate to practicetestautomation.com")
    public void navigateToLoginPage(){
        paginaLogin.navigateToPTA();
    }
    @When("I enter a correct credentials")
    public void enterCredentials(){
        paginaLogin.enterCredentialsLogin();
        paginaLogin.clickSubmitButton(); //hacemos clic en submit
    }
    @Then("I can log in correctly")
    public void successPage(){
        paginaLogin.assertLoginOK();
    }
    
}
