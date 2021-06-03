import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageResult {

    WebDriver driver;


    public SearchPageResult (WebDriver driver){
        this.driver=driver;
    }

    public String get_true_Text() {
        String Name = driver.findElement(By.cssSelector(".lighter")).getText();

        return Name;
    }





    public  String get_false_Text()
    {
        String textResult=driver.findElement(By.cssSelector(".alert")).getText();

        return textResult;

    }
}
