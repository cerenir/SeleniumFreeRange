package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaginaLogin extends BasePage {

    private String campoUser = "//input[@id='username']"; 
    private String campoPass = "//input[@id='password']"; 
    private String buttonSubmit = "//button[@id='submit']"; 
    private String messageLoginOK = "//h1[@class='post-title']"; 


    public PaginaLogin(){
        super(driver);
    }

    public void navigateToPTA(){
        navigateTo("https://practicetestautomation.com/practice-test-login/");
    }
    public void enterCredentialsLogin(){
        write(campoUser, "student"); //escribimos login
        write(campoPass, "Password123"); //escribimos pass
    }
    public void clickSubmitButton(){
        clickElement(buttonSubmit);
    }
    //comprobar el login correcto.
    public void assertLoginOK(){
        WebElement cabecera = driver.findElement(By.xpath(messageLoginOK));
        String textoCabecera = cabecera.getText();
        Assert.assertEquals(textoCabecera,"Logged In Successfully");
    }
    
}
