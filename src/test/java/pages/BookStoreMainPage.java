package pages;

public class BookStoreMainPage extends BasePage {

    public BookStoreMainPage(){
        super(driver);
    }

    public void navigateToBookStoreMain(){
        navigateTo("https://demoqa.com/books");
    }
    
}
