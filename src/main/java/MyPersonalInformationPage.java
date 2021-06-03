import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPersonalInformationPage {
    WebDriver driver;
    By backToMyCountSelector = By.cssSelector(".footer_links li:nth-of-type(1)");

    public MyPersonalInformationPage(WebDriver driver){
        this.driver=driver;
    }
    public MyAccountPage backToMyAccount(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(backToMyCountSelector));

        driver.findElement(backToMyCountSelector).click();
        return new MyAccountPage(driver);
    }

    public MyAccountPage backToMyAccountAfterVerificationExistingLogo(){
        By logoSelector = By.cssSelector("#header_logo>a>img");

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(logoSelector));

        if (driver.findElement(logoSelector).isDisplayed())
        {
            System.out.println("le logo est présent");
        }else{
            System.out.println("ouuuups le logo n'est pas présent");
        }
        driver.findElement(backToMyCountSelector).click();
        return new MyAccountPage(driver);
    }

    public String getMyPersonalInformationText(){
        By PersonalInfoTextSelector = By.cssSelector(".box>.page-subheading");
        String resultFound = driver.findElement(PersonalInfoTextSelector).getText();
        return resultFound;
    }

}
