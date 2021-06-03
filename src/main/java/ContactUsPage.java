import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage backToMyAccountPage() {
        By logoSelector = By.cssSelector("#header_logo>a>img");
        By backToMyCountSelector = By.cssSelector(".header_user_info>a.account");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(logoSelector));


        if (driver.findElement(logoSelector).isDisplayed()) {
            System.out.println("le logo est présent");
        } else {
            System.out.println("ouuuups le logo n'est pas présent");
        }

        wait.until(ExpectedConditions.elementToBeClickable(backToMyCountSelector));
        driver.findElement(backToMyCountSelector).click();
        return new MyAccountPage(driver);
    }
}