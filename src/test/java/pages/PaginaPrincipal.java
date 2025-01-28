package pages;

public class PaginaPrincipal extends BasePage {

    //private String accessButton = "//a[@class='sc-epnzzT hDyKSo']";
    //private String sectionLink = "//a[normalize-space()='Recursos' and @href]"; ejemplo pasando directamente el xpath
    private String sectionLink = "//a[normalize-space()='%s' and @href]"; 
    //private String elegirUnPlanButton = "";

    public PaginaPrincipal(){
        super(driver);
    }

    //creamos metodo de clase para navegar a la web
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
        //clickElement(accessButton);
    }
/*     //otro ejemplo de metodo que me lleva a Google
        public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }  */
    //hacer clic en cada uno de los elementos de la barra superior que pasamos por parámetro.
    public void clickOnSectionNavigationBar(String section){
        //reemplaza el marcador de posisicion en sectionLink con el nombre
        String xpathSection = String.format(sectionLink,section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton(){
    }
    
}
