package runner;
 
import org.junit.AfterClass;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos .feature
                glue = "steps", // Paquete donde tenemos nuestras clases definiendo los steps
                //plugin = { "pretty", "html:target/cucumber-reports" }, 
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
                tags = "@BookStore")
 
public class TestRunner {
        @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }
 
}