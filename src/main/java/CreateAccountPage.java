import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
    WebDriver driver;

    By sexSelector = By.cssSelector("#uniform-id_gender1");
    By firstNameSelector = By.cssSelector("#customer_firstname");
    By lasttNameSelector = By.cssSelector("#customer_lastname");
    //By emailSelector = By.cssSelector("#email");
    By passSelector = By.cssSelector("#passwd");
    By daySelector = By.cssSelector("#days>[value=\"10\"]");
    By monthSelector = By.cssSelector("#months>[value=\"10\"]");
    By yearSelector = By.cssSelector("#years>[value=\"1993\"]");
    By adressSelector = By.cssSelector("#address1");
    By citySelector = By.cssSelector("#city");
    By stateSelector = By.cssSelector("#id_state>[value='2']");
    By postalCodeSelector = By.cssSelector("#postcode");
    By contrySelector = By.cssSelector("#id_country");
    By phoneNumberSelector = By.cssSelector("#phone_mobile");
    By registerAcount = By.cssSelector("#submitAccount");
    
    public CreateAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public CreateAccountPage enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameSelector));

        driver.findElement(firstNameSelector).sendKeys(name);
        return this;
    }

        public CreateAccountPage enterLastName(String lastName) {

            driver.findElement(lasttNameSelector).sendKeys(lastName);
            return this;
        }

    public CreateAccountPage enterZip(String zip) {

        driver.findElement(postalCodeSelector).sendKeys(zip);

        return this;
    }

    public CreateAccountPage enterPassword (String password) {

        driver.findElement(passSelector).sendKeys(password);
        return this;
    }

    public CreateAccountPage enterAddress (String address) {

        driver.findElement(adressSelector).sendKeys(address);
        return this;
    }

    public CreateAccountPage enterCity (String city) {

        driver.findElement(citySelector).sendKeys(city);
        return this;
    }

    public CreateAccountPage chooseSex () {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(sexSelector));

        driver.findElement(sexSelector).click();
        return this;
    }

    public CreateAccountPage chooseState () {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(stateSelector));

        driver.findElement(stateSelector).click();
        return this;
    }

    public CreateAccountPage birthDay () {
        driver.findElement(daySelector).click();
        driver.findElement(monthSelector).click();
        driver.findElement(yearSelector).click();
        return this;
    }

    public CreateAccountPage chooseCountry () {
        driver.findElement(contrySelector).click();
        return this;
    }
        //driver.findElement(emailSelector).sendKeys("");

    public CreateAccountPage enterPhoneNumber (String phoneNumber) {

        driver.findElement(phoneNumberSelector).sendKeys(phoneNumber);
        return this;
    }

    public MyAccountPage registerButton () {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(registerAcount));

        driver.findElement(registerAcount).click();
        return new MyAccountPage(driver);
    }

    }


