package pages;

public class PaginaFundamentosTesting extends BasePage {

    private String introduccionTestingLink = "//a[@class='sc-epnzzT fnnVGR']";

    public PaginaFundamentosTesting(){
        super(driver);
    }

    public void clickIntroduccionTestingLink(){
        clickElement(introduccionTestingLink);
    }
    
}
