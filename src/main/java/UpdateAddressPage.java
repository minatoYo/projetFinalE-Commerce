import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateAddressPage {

    WebDriver driver;
    By saveButtonSelector = By.cssSelector("#submitAddress");
    By updatedAddressSelector = By.cssSelector("#address1");
    By stateSelector = By.cssSelector("#id_state>[value='2']");
    By updatedCitySelector = By.cssSelector("#city");
    By updatedZIPSelector = By.cssSelector("#postcode");
    By updatedPhoneSelector = By.cssSelector("#phone");
    By updatedAliasSelector = By.cssSelector("#alias");

    public UpdateAddressPage(WebDriver driver){
        this.driver=driver;
    }



    public MyAdressesPage updateAddress(String updatedAddress){
        driver.findElement(updatedAddressSelector).clear();
        driver.findElement(updatedAddressSelector).sendKeys(updatedAddress);
        driver.findElement(saveButtonSelector).click();
        return new MyAdressesPage(driver);
    }

    public UpdateAddressPage chooseState () {
        driver.findElement(stateSelector).click();
        return this;
    }


    public MyAdressesPage createNewAddress(String newAddress,String city,String zip,String phone,String assignedAddress){
        driver.findElement(updatedAddressSelector).clear();
        driver.findElement(updatedAddressSelector).sendKeys(newAddress);
        driver.findElement(updatedCitySelector).sendKeys(city);
        driver.findElement(updatedZIPSelector).sendKeys(zip);
        driver.findElement(updatedPhoneSelector).sendKeys(phone);
        driver.findElement(updatedAliasSelector).sendKeys(assignedAddress);
        driver.findElement(saveButtonSelector).click();
        return new MyAdressesPage(driver);
    }

}
