import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    WebDriver driver;



    public OrderHistoryPage(WebDriver driver){
        this.driver=driver;
    }
    public MyAccountPage backToMyAccount(){
        By backToMyCountSelector = By.cssSelector(".footer_links li:nth-of-type(1)");
        driver.findElement(backToMyCountSelector).click();
        return new MyAccountPage(driver);
    }
}