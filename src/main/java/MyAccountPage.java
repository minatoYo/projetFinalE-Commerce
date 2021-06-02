import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage {
    WebDriver driver;
    By orderHistorySelector = By.cssSelector(".icon-list-ol");
    By creditSlipSelector = By.cssSelector(".icon-ban-circle");
    By myAdressSelector = By.cssSelector(".icon-building");
    By myPersonalInfoSelector = By.cssSelector(".icon-user");
    By myWishListSelector = By.cssSelector(".icon-heart");
    By homeSelector = By.cssSelector(".footer_links>li>a");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
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

    public HomePage goToHomePage(){
        driver.findElement(homeSelector).click();
        return new HomePage(driver);
    }

    public MyAccountPage displayMyAccountText(){
        String reslutExpected = "MY ACCOUNT";
        By textMyAccountSelector = By.cssSelector(".page-heading");
        String resultFound  = driver.findElement(textMyAccountSelector).getText();

        Assert.assertEquals(resultFound,reslutExpected);
        return this;

    }
}