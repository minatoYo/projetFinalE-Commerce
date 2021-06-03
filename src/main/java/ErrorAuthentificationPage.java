import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ErrorAuthentificationPage {
    WebDriver driver;
    By errorMessagePasswordSelector = By.cssSelector(".alert-danger>ol>li");

    public ErrorAuthentificationPage(WebDriver driver){
        this.driver=driver;
    }

    public String getErrorMessage(){
        String resultExpected = "Authentification failed.";

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePasswordSelector));

        String resultFound = driver.findElement(errorMessagePasswordSelector).getText();

        return resultFound;

    }

}
