import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    By signInLinkSelector = By.cssSelector(".login");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public AuthentificationPage goToSignInPage(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(signInLinkSelector));

        driver.findElement(signInLinkSelector).click();
        return new AuthentificationPage(driver);
    }

    public HomePage entrer_text_dresses()
    {
        By text_search=By.id("search_query_top");
        driver.findElement(text_search).sendKeys("dresses ");

        return this ;
    }

    public HomePage entrer_text_xbox()
    {
        By text_search=By.id("search_query_top");
        driver.findElement(text_search).sendKeys("xbox");

        return this ;
    }
    /*
    architecture ,screeshot ,comment ca marché  gonogo dashboard si possible
     */
    public SearchPageResult go_to_wen()
    {
        By loupe_search=By.cssSelector("[name='submit_search']");
        driver.findElement(loupe_search).click();
        return new SearchPageResult(driver);
    }


    //ac_even
    public ArticleOpenning entrer_text_completion()
    {
        entrer_text_dresses();
        By text_search=By.cssSelector(".ac_results li:nth-of-type(2)");
        driver.findElement(text_search).click();
        return new ArticleOpenning(driver);
    }

    //.sf-menu  li:nth-of-type(2)

    public HomePage page_women_all_sous_menu()
    {
        By women=By.cssSelector(".sf-menu  li:nth-of-type(1)");
        driver.findElement(women).click();

        By women1=By.cssSelector(".sf-menu  li:nth-of-type(2)");
        driver.findElement(women).click();

        By women2=By.cssSelector(".sf-menu  li:nth-of-type(3)");
        driver.findElement(women).click();




        return this;
    }


}
