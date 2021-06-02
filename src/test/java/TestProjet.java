import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestProjet {

    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeChrome() {
        //driver.quit();
    }

    @Test //Account creation (Us 01)
    public void testCreateAccount() {

        HomePage hm = new HomePage(driver);
                hm
                .goToSignInPage()
                .signUp("xtelle_saakkkde9@hotmail.com")
                .enterName("rtgr'g")
                .enterLastName("az'tr")
                .enterPassword("mdamspmspei75@")
                .enterAddress("dchgaiyegduiaehdoz deafzef fezfze")
                .enterZip("95100")
                .enterCity("paris")
                .chooseSex()
                .chooseState()
                .birthDay()
                .chooseCountry()
                .enterPhoneNumber("0605712275")
                .registerButton();
    }

    @Test //Vérification du contenu de la page "MY ACCOUNT"et du bouton "Home"  (Us 01)
    public void testMyAccountContains() {
        HomePage hm = new HomePage(driver);
                hm
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .getymyusernametext()  // vérifier la prsence du userName sur la page
                .goToOrderHistoryPage()
                .backToMyAccount()
                .goToCreditSlipPage()
                .backToMyAccount()
                .goToAddressPage()
                .backToMyAccount()
                .goToPersonalInformationPage()
                .backToMyAccount()
                .goToWishlistsPage()
                .backToMyAccount()
                .goToHomePage();
    }

    @Test //   (Us 02)
    public void testAccountConnection() {
        String reslutExpected = "MY ACCOUNT";

        HomePage hm = new HomePage(driver);
        String a = hm
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .getMyAccountText();

        Assert.assertEquals(a, reslutExpected);  // vérifier la presence du texte : MY ACCOUNT
    }

        @Test  // (Us 02)
        public void faildAuthentification() {
            String resultExpected = "Authentification failed.";

            HomePage hm = new HomePage(driver);
                  String a =  hm
                    .goToSignInPage()
                    .enterWrongPassword("fouaddjouadi1@gmail.com", "02020202") // mettre un faut password
                    .getErrorMessage();

            Assert.assertEquals(a,resultExpected);  // vérifier bien si Authenfication failed" s'affiche
        }
    }

