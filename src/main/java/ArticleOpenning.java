import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleOpenning {

    WebDriver driver;


    public ArticleOpenning (WebDriver driver){
        this.driver=driver;
    }

    public String get_Text_completion() {
        String Name = driver.findElement(By.cssSelector("[itemprop='name']")).getText();

        return Name;
    }
}
