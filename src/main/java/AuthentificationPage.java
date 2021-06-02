import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthentificationPage {
    WebDriver driver;

    By emailSelector = By.cssSelector("#email");
    By passwordSelector = By.cssSelector("#passwd");
    By signInSelecor = By.cssSelector("#SubmitLogin");
    By emailAdressSelector = By.cssSelector("#email_create");
    By creatAccountSelector = By.cssSelector("#SubmitCreate");


    public AuthentificationPage(WebDriver driver){
        this.driver=driver;
    }

    public MyAccountPage logIn(String mail, String password){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailSelector));

        driver.findElement(emailSelector).sendKeys(mail);
        driver.findElement(passwordSelector).sendKeys(password);

        driver.findElement(signInSelecor).click();
        return new MyAccountPage(driver);
    }

    public CreateAccountPage signUp(String mail){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAdressSelector));

        driver.findElement(emailAdressSelector).sendKeys(mail);
        driver.findElement(creatAccountSelector).click();
       return new CreateAccountPage(driver);
    }

    public ErrorAuthentificationPage enterWrongPassword(String mail, String incorrectPassword){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailSelector));

        driver.findElement(emailSelector).sendKeys(mail);
        driver.findElement(passwordSelector).sendKeys(incorrectPassword);
        driver.findElement(signInSelecor).click();

        return new ErrorAuthentificationPage(driver);
    }
}
