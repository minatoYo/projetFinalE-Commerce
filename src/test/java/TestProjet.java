import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        @Test  // test us 03 (Vérification du Logo sur toutes les pages)
        public void testExistingLogoOnAllPages(){
        HomePage hm = new HomePage(driver);
            hm
                    .goToSignInPage()
                    .logIn("fouaddjouadi1@gmail.com", "azerty")
                    .goToOrderHistoryPage()
                    .backToMyAccountAfterVerificationExistingLogo()
                    .goToCreditSlipPage()
                    .backToMyAccountAfterVerificationExistingLogo()
                    .goToAddressPage()
                    .backToMyAccountAfterVerificationExistingLogo()
                    .goToPersonalInformationPage()
                    .backToMyAccountAfterVerificationExistingLogo()
                    .goToWishlistsPage()
                    .backToMyAccountAfterVerificationExistingLogo()
                    .goToWomenPage()
                    .backToMyAccountPage()
                    .goToCardPage()
                    .backToMyAccountPage()
                    .goToContactUsdPage()
                    .backToMyAccountPage()
                    .clickOnlogo();

        }

    @Test //(US 06)
    public void TestAddress() {
        String expectedString = "MY ADDRESS";
        HomePage AutomationPracticeHomePage = new HomePage(driver);
        String addressSpaceTitle = AutomationPracticeHomePage
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .goToAddressPage()
                .getAddressSpaceTitle();
        // Asserts
        Assert.assertEquals(addressSpaceTitle, expectedString);

    }

    @Test // (US 06)
    public void TestClientInformation() {

        String expectedName = "Fouad";
        String expectedLastName = "DJOUADI";
        String expectedAddress = "UPDATED ADDRESS";
        String expectedPhoneNumber = "0605712272";

        HomePage AutomationPracticeHomePage = new HomePage(driver);
        MyAdressesPage AddressPage = AutomationPracticeHomePage
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .goToAddressPage();

        String lastName = AddressPage.getLastName();
        String name = AddressPage.getName();
        String address = AddressPage.getAddress();
        String phoneNumber = AddressPage.getPhoneNumber();

        // Asserts
        Assert.assertEquals(name, expectedName);
        Assert.assertEquals(lastName, expectedLastName);
        Assert.assertEquals(phoneNumber, expectedPhoneNumber);
        Assert.assertEquals(address, expectedAddress);

    }


    @Test // (US 06)
    public void UpdateAdressTest() {

        String updatedAddress = "UPDATED ADDRESS";
        HomePage AutomationPracticeHomePage = new HomePage(driver);
        MyAdressesPage AdressPage = AutomationPracticeHomePage
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .goToAddressPage()
                .goToUpdateAddress()
                .updateAddress(updatedAddress);

    }

    @Test //(US 06)
    public void AddNewAdressTest() {

        String newAddress = "NEW ADDRESS";
        HomePage AutomationPracticeHomePage = new HomePage(driver);
        MyAdressesPage AdressPage = AutomationPracticeHomePage
                .goToSignInPage()
                .logIn("fouaddjouadi1@gmail.com", "azerty")
                .goToAddressPage()
                .goToAddAnAddress()
                .chooseState()
                .createNewAddress("b","paris","13008","4","assigned");

    }

    @Test  // (Us 04)
    public void searchProduct() {
        String textProductExpected = "\"DRESSES \"";
        HomePage hm = new HomePage(driver);
        hm
                .entrer_text_dresses()
                .go_to_wen();


        String textProduct = new SearchPageResult(driver).get_true_Text();

        // Asserts
        Assert.assertEquals(textProduct ,textProductExpected );

    }


    @Test  // (Us 04)
    public void searchWrongProduct() {
        String textWrongProductExpected = "No results were found for your search \"xbox\"";
        HomePage hm = new HomePage(driver);
        hm
                .entrer_text_xbox()
                .go_to_wen();

        String textWrongProduct = new SearchPageResult(driver).get_false_Text();

        // Asserts
        Assert.assertEquals(textWrongProduct,textWrongProductExpected );

    }



    @Test  // (Us 04)
    public void searchTextResultCompletion() {
        String textCompletionResultExpected="Printed Dress";
        HomePage hm = new HomePage(driver);
        hm
                .entrer_text_completion();

        String textCompletionProduct = new ArticleOpenning(driver).get_Text_completion();

        // Asserts
        Assert.assertEquals(textCompletionProduct,textCompletionResultExpected);


    }

    @Test  // (Us 04)
    public void GoToAllPage() {

        WebElement search=driver.findElement(By.cssSelector("[name='submit_search']"));
        WebElement wen =driver.findElement(By.id("search_query_top"));
        HomePage hm = new HomePage(driver);
        hm
                .page_women_all_sous_menu();



        //Assert.assertTrue(search.isDisplayed(),"la recherche n'es pas visible ");
       // Assert.assertTrue(wen.isDisplayed(),"la loupe nes pas visible ");


    }


}
