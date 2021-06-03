import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAdressesPage {
    WebDriver driver;

    By backToMyCountSelector = By.cssSelector(".footer_links li:nth-of-type(1)");
    By addressSpaceTitleSelector = By.cssSelector("div h3");
    By phoneSelector = By.cssSelector(".last_item li:nth-of-type(7)");
    By nameSelector = By.cssSelector(".address_name:nth-of-type(1)");
    By lastNameSelector = By.cssSelector(".address_name:nth-of-type(2)");
    By addressSelector = By.cssSelector(".address_address1");

    public MyAdressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage backToMyAccount() {

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

    public UpdateAddressPage goToUpdateAddress() {
        By goToUpdateAddressSelector = By.cssSelector("[title=\'Update\']");
        driver.findElement(goToUpdateAddressSelector).click();
        return new UpdateAddressPage(driver);
    }

    public UpdateAddressPage goToAddAnAddress() {
        By goToAddAnAddressSelector = By.cssSelector("[title=\'Add an address\']");
        driver.findElement(goToAddAnAddressSelector).click();
        return new UpdateAddressPage(driver);
    }



    public String getAddressSpaceTitle() {
    String addressSpaceTitleLabel = driver.findElement(addressSpaceTitleSelector).getText();
    return addressSpaceTitleLabel;
    }

    public String getName() {
        String Name = driver.findElement(nameSelector).getText();
        return Name;
    }

    public String getLastName() {
        String lastName = driver.findElement(lastNameSelector).getText();
        return lastName;
    }

    public String getAddress() {
        String address = driver.findElement(addressSelector).getText();
        return address;
    }


    public String getPhoneNumber() {
       String phoneNumber = driver.findElement(phoneSelector).getText();
       return phoneNumber;
    }



}