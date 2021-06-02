import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(emailSelector).sendKeys(mail);
        driver.findElement(passwordSelector).sendKeys(password);

        // vérify existing Sign Button
        boolean isEnbledSign = driver.findElement(signInSelecor).isEnabled();
        boolean isDisplayedSign = driver.findElement(signInSelecor).isDisplayed();

                if(isEnbledSign){
                    System.out.println("Sign button is Enabled");
                }else
                    System.out.println("Sign button is not Enabled");

                if(isDisplayedSign){
                    System.out.println("Sign button is Displayed");
                }else
                    System.out.println("Sign button is Displayed");

        driver.findElement(signInSelecor).click();
        return new MyAccountPage(driver);
    }

    public CreateAccountPage signUp(String mail){
       driver.findElement(emailAdressSelector).sendKeys(mail);
       driver.findElement(creatAccountSelector).click();
       return new CreateAccountPage(driver);
    }

    public ErrorAuthentificationPage enterWrongPassword(String mail, String incorrectPassword){

        driver.findElement(emailSelector).sendKeys(mail);
        driver.findElement(passwordSelector).sendKeys(incorrectPassword);
        driver.findElement(signInSelecor).click();

        return new ErrorAuthentificationPage(driver);
    }
}
