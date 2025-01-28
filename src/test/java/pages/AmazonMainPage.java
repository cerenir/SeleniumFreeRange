package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AmazonMainPage extends BasePage {

    private String searchBar = "//input[@id='twotabsearchtextbox']";
    private String submitButton = "//input[@id='nav-search-submit-button']";
    private String indexSecondPageButton = "//a[@aria-label='Ir a la página 2']";
    private String thirtdElementCartButton = "//button[@id='a-autoid-137-announce']";
    private String thirdElement ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]";
    private String cartButton = "//input[@id='add-to-cart-button']";
    private String addedMessageText = "//*[contains(text(),'Agregado al carrito')]";

    public AmazonMainPage (){
        super(driver);
    }
    public void navigateToAmazon(){
        navigateTo("http://www.amazon.es");
    }
    public void searchWord(String word){
        write(searchBar, word);
        clickElement(submitButton);
    }
    public void navigatePage(String pageNumber){
        goToLinkText("2");
    }
    public void selectItem(){
        clickElement(thirdElement);
    }
    public void addItemToCart(){
        clickElement(thirtdElementCartButton);
    }
    public String addedToCartMessage(){
        return textFromElement(addedMessageText);      
    }
    

}
