import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardClass {

    private static WebDriver driver;
    public static void expliciteWaitToBeClickable(String selector){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static void visibilityOfElementLocated (String selector){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }
}
