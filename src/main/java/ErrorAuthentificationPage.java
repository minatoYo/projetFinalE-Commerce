import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ErrorAuthentificationPage {
    WebDriver driver;
    By errorMessagePasswordSelector = By.cssSelector(".alert-danger>ol>li");

    public ErrorAuthentificationPage(WebDriver driver){
        this.driver=driver;
    }

    public ErrorAuthentificationPage getErrorMessage(){

        String resultExpected = "Authentification failed.";
        String resultFound = driver.findElement(errorMessagePasswordSelector).getText();
        System.out.println(resultFound);

        Assert.assertEquals(resultFound,resultExpected);
        return this;
    }

}
