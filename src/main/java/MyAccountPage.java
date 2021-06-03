import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    WebDriver driver;
    By orderHistorySelector = By.cssSelector(".icon-list-ol");
    By creditSlipSelector = By.cssSelector(".icon-ban-circle");
    By myAdressSelector = By.cssSelector(".icon-building");
    By myPersonalInfoSelector = By.cssSelector(".icon-user");
    By myWishListSelector = By.cssSelector(".icon-heart");
    By homeSelector = By.cssSelector(".footer_links>li>a");
    By usernameDisplaySelector = By.cssSelector(".header_user_info>a>span");
    By logoSelector = By.cssSelector("#header_logo>a>img");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public String getymyusernametext() {
        String reslutExpected = "Fouad DJOUADI";
        String resultFound = driver.findElement(usernameDisplaySelector).getText();
        return resultFound;
    }
    public OrderHistoryPage goToOrderHistoryPage(){
        driver.findElement(orderHistorySelector).click();
        return new OrderHistoryPage(driver);
    }

    public MyCreditSlipsPage goToCreditSlipPage(){
        driver.findElement(creditSlipSelector).click();
        return new MyCreditSlipsPage(driver);
    }

    public MyAdressesPage goToAddressPage(){
        driver.findElement(myAdressSelector).click();
        return new  MyAdressesPage(driver);
    }

    public MyPersonalInformationPage goToPersonalInformationPage(){
        driver.findElement(myPersonalInfoSelector).click();
        return new MyPersonalInformationPage(driver);
    }

    public MyWishlistsPage goToWishlistsPage(){
        driver.findElement(myWishListSelector).click();
        return new MyWishlistsPage(driver);
    }

    public WomenPage goToWomenPage(){
        By womenSelector =  By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.elementToBeClickable(womenSelector));

        driver.findElement(womenSelector).click();

        return new WomenPage(driver);
    }

    public CartPage goToCardPage(){

        By cardSelector =  By.cssSelector(".shopping_cart>a");
        driver.findElement(cardSelector).click();

        return new CartPage(driver);
    }
    public ContactUsPage goToContactUsdPage(){

        By contactUsSelector =  By.cssSelector("#contact-link");
        driver.findElement(contactUsSelector).click();

        return new ContactUsPage(driver);
    }

    public HomePage clickOnlogo(){

        driver.findElement(logoSelector).click();

        return new HomePage(driver);
    }
    public HomePage goToHomePage(){

        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeSelector));

        driver.findElement(homeSelector).click();
        return new HomePage(driver);
    }

    public String getMyAccountText(){
        By textMyAccountSelector = By.cssSelector(".page-heading");
        String resultFound = driver.findElement(textMyAccountSelector).getText();
        return resultFound;
    }


}
