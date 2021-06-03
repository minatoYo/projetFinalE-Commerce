import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    By stateSelector = By.cssSelector("#id_state");
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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

        public CreateAccountPage enterLastName(String lastName) {

            driver.findElement(lasttNameSelector).sendKeys(lastName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this;
        }

    public CreateAccountPage enterZip(String zip) {

        driver.findElement(postalCodeSelector).sendKeys(zip);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateAccountPage enterPassword (String password) {

        driver.findElement(passSelector).sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateAccountPage enterAddress (String address) {

        driver.findElement(adressSelector).sendKeys(address);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateAccountPage enterCity (String city) {

        driver.findElement(citySelector).sendKeys(city);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateAccountPage chooseSex() {
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(sexSelector));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(sexSelector).click();
        return this;
    }

    public CreateAccountPage chooseState(int index) {
        WebDriverWait wait = new WebDriverWait(driver,10);

        Select stateDropdown = new Select(driver.findElement(stateSelector));
        stateDropdown.selectByIndex(index);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CreateAccountPage birthDay () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(daySelector).click();
        driver.findElement(monthSelector).click();
        driver.findElement(yearSelector).click();
        return this;
    }

    public CreateAccountPage chooseCountry () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(contrySelector).click();
        return this;
    }
        //driver.findElement(emailSelector).sendKeys("");

    public CreateAccountPage enterPhoneNumber (String phoneNumber) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(phoneNumberSelector).sendKeys(phoneNumber);
        return this;
    }

    public MyAccountPage registerButton () {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(registerAcount));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(registerAcount).click();
        return new MyAccountPage(driver);
    }

    }


