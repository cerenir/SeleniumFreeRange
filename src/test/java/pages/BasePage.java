package pages;
 
// Importaciones necesarias
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
    private static Actions action;
    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();
 
        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }
 
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como
     * argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
 
    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }
 
    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        driver.quit();
    }
    //elige el indice que le pasamos de la página y hace clic
    public void goToLinkText(String linkText){
        //driver.findElement(By.linkText(linkText)).click();
        Find(linkText).click();
    }
 
    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    //si el elemento está visible, continua, si no lo está, espera X segundos (definidos en el wait) y si apareció, sigue
    // si no, tira excepción
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
 
    public void clickElement(String locator) {
        Find(locator).click();
    }
    //obtiene el texto de un elemento
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
 
    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }
 
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
 
    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
 
    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }
    //situar el ratón sobre un elemento para marcarlo
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }
    //hacer doble click
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    //hacer right click
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //obtener los valores de un dropdown
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));
 
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        return values;
    }

/*METODOS QUE COMPRUEBAN PROPIEDADES DE UN ELEMENTO, SI ESTÁ PRESENTE, HABILITADO, SELECCIONADO ETC*/ 

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    /*-------------*/
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //cierra una alerta que no nos interesa
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            System.out.println("La alerta no está presente");
            e.printStackTrace();
        }
    } 
}