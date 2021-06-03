import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    By signInLinkSelector = By.cssSelector(".login");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public AuthentificationPage goToSignInPage(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(signInLinkSelector));

        driver.findElement(signInLinkSelector).click();
        return new AuthentificationPage(driver);
    }

}
