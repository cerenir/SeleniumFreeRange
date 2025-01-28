package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonMainPage;

public class AmazonSteps {

    AmazonMainPage paginaAmazon = new AmazonMainPage();

    @Given("the user navigates to www.amazon.com")
    public void navigateToAmazonPage(){
        paginaAmazon.navigateToAmazon();
    }
    @When("the user searches for {word}")
    public void searchForWord(String product){
        paginaAmazon.searchWord(product);
    }
    @And("navigates to page number (.+)$")
    public void navigateToPage(String pageNumber){
        paginaAmazon.navigatePage(pageNumber);
    }
    @And("selects the third item")
    public void selectItem(){
        paginaAmazon.addItemToCart();
    }
    @Then("the user is able to add it to the cart")
    public void checkItemAddItemToCart(){
        paginaAmazon.addItemToCart();
        Assert.assertEquals("Agregado al carrito", paginaAmazon.addedToCartMessage());
    }

    
    
}
