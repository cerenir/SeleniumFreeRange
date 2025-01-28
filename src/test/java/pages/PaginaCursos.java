package pages;

public class PaginaCursos extends BasePage {
    
    private String fundamentosTeString = "//h3[normalize-space()='Introducción al Testing de Software']";

    public PaginaCursos(){
        super(driver);
    }

    public void clickFundamentosTestingLink(){
        clickElement(fundamentosTeString);
    }
}
