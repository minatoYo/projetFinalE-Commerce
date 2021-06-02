import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCreditSlipsPage {
    WebDriver driver;
    By backToMyCountSelector = By.cssSelector(".footer_links li:nth-of-type(1)");

    public MyCreditSlipsPage(WebDriver driver){
        this.driver=driver;
    }
    public MyAccountPage backToMyAccount(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(backToMyCountSelector));
        driver.findElement(backToMyCountSelector).click();
        return new MyAccountPage(driver);
    }//

}
