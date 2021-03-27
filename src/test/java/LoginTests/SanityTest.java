package LoginTests;

import FrameWork.ItemDetails;
import FrameWork.MainTestSetUp;
import FrameWork.Utilities.ReadFromXml;
import PageFactoryModel.*;
import PageObjectModel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SanityTest extends MainTestSetUp {

    ItemDetails item;

    @Before
    public void setUp() {
        try {
            this.mainSetUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        mainTestTearDown();
    }

    public SanityTest(String itemName,String itemLocator, String price, String quantity, String size, String color) {
        item = new ItemDetails(itemName,itemLocator,price,quantity,size,color);
    }

    @Parameterized.Parameters
    public static Collection inputs() throws IOException {
        return ReadFromXml.ItemsInfo("D:\\Plamen\\QA\\Bin\\FrameWork.xlsx");
    }

    @Test
    public void sanityTestPOM() throws IOException, InterruptedException {
        HomePagePOM homePage = new HomePagePOM(this.driver, this.getUsername());
        homePage.navigateTo(this.getMainURL());
        LoginPagePOM loginPage = homePage.openSingInPage();
        RegistrationPagePOM registrationPage = loginPage.createAnAccount(this.getUsername());
        LoggedInPagePOM loggedInPage = registrationPage.register();
        //loginPage.login(this.getUsername(),this.getPassword());
        loggedInPage.goToHomePage();
        ProductDetailsPagePOM productDetailsPage = homePage.openItems(item.itemLocator);
        productDetailsPage.addToCart(item);
        CheckoutSummaryPagePOM checkoutSummaryPage = productDetailsPage.proceedToCheckout();
        CheckoutAddressPagePOM checkoutAddressPage = checkoutSummaryPage.validateValuesAndProceed(item);
        checkoutAddressPage.validateAddressFields(this.getUsername());
        CheckoutShippingPagePOM checkoutShippingPage = checkoutAddressPage.proceedToShipping();
        CheckoutPaymentPagePOM checkoutPaymentPage = checkoutShippingPage.acceptAndProceed();
        checkoutPaymentPage.validatePrices();
        checkoutPaymentPage.payWithBankWire();
    }

    @Test
    public void sanityTestFactory() throws IOException, InterruptedException {
        HomePageFactory homePage = new HomePageFactory(this.driver, this.getUsername());
        homePage.navigateTo(this.getMainURL());
        LoginPageFactory loginPage = homePage.openSingInPage();
       //RegistrationPageFactory registrationPage = loginPage.createAnAccount(this.getUsername());
       //LoggedInPageFactory loggedInPage = registrationPage.register();
        loginPage.login(this.getUsername(),this.getPassword());
        loginPage.goToHomePage();
        ProductDetailsPageFactory productDetailsPage = homePage.openItems(item.itemLocator);
        productDetailsPage.addToCart(item);
        CheckoutSummaryPageFactory checkoutSUmmaryPage = productDetailsPage.proceedToCheckout();
        CheckoutAddressPageFactory checkoutAddressPage = checkoutSUmmaryPage.validateValuesAndProceed(item);
        checkoutAddressPage.validateAddressFields(this.getUsername());
        CheckoutShippingPageFactory checkoutShippingPage = checkoutAddressPage.proceedToShipping();
        CheckoutPaymentPageFactory checkoutPaymentPage = checkoutShippingPage.acceptAndProceed();
        checkoutPaymentPage.validatePrices();
        checkoutPaymentPage.payWithCheck();
    }
}
