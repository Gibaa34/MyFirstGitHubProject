package PageFactoryModel;

import FrameWork.Utilities.ReadFromXml;
import PageObjectModel.CheckoutShippingPagePOM;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static FrameWork.MainTestSetUp.INIT_PATH;

public class CheckoutAddressPageFactory extends RegistrationPageFactory {

    WebDriver driver;

    @FindBy(css = "#order_step li:nth-of-type(1)")
    WebElement backToSummaryPage;

    @FindBy(id = "addressesAreEquals")
    WebElement deliveryAddressCheckbox;

    @FindBy(css = "#address_delivery li:nth-of-type(2)")
    WebElement deliveryAddressNames;

    @FindBy(css = "#address_delivery li:nth-of-type(5)")
    WebElement deliveryAddressCity;

    @FindBy(css = "#address_delivery li:nth-of-type(6)")
    WebElement deliveryAddressCountry;

    @FindBy(css = "#address_delivery li:nth-of-type(7)")
    WebElement deliveryAddressPhoneNum;

    @FindBy(css = "#address_delivery li:nth-of-type(8)")
    WebElement deliveryAddressMobileNum;

    @FindBy(css = "#address_invoice li:nth-of-type(2)")
    WebElement billingAddressNames;

    @FindBy(css = "#address_invoice li:nth-of-type(5)")
    WebElement billingAddressCity;

    @FindBy(css = "#address_invoice li:nth-of-type(6)")
    WebElement billingAddressCountry;

    @FindBy(css = "#address_invoice li:nth-of-type(7)")
    WebElement billingAddressPhoneNum;

    @FindBy(css = "#address_invoice li:nth-of-type(8)")
    WebElement billingAddressMobileNum;

    @FindBy(css = "p[class='address_add submit'] > a[title='Add']")
    WebElement addNewAddressBtn;

    @FindBy(css = "[name='message']")
    WebElement commentField;

    @FindBy(css = "[class='button btn btn-default button-medium']")
    WebElement proceedToShippmentPage;

    public CheckoutAddressPageFactory() {

    }

    public CheckoutAddressPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateAddressFields(String email) {
        List<String> details = new ArrayList<>();
        try {
            details = ReadFromXml.UserRegistrationDetails(INIT_PATH, email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(deliveryAddressNames.getText(),details.get(2)+" "+details.get(3));
        Assert.assertEquals(deliveryAddressCity.getText(),billingAddressCity.getText());
        Assert.assertEquals(deliveryAddressCountry.getText(),details.get(14));
        Assert.assertEquals(deliveryAddressPhoneNum.getText(),details.get(16));
        Assert.assertEquals(deliveryAddressMobileNum.getText(),details.get(17));
    }

    public void leaveComment(String text) {
        commentField.sendKeys(text);
    }

    public CheckoutShippingPageFactory proceedToShipping() {
        proceedToShippmentPage.click();
        return new CheckoutShippingPageFactory(driver);
    }
}
