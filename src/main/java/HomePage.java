import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By signInLinkSelector = By.cssSelector(".login");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public AuthentificationPage goToSignInPage(){
        driver.findElement(signInLinkSelector).click();
        return new AuthentificationPage(driver);
    }

}
