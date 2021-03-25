package PageObjectModel;

import FrameWork.Utilities.ReadFromXml;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static FrameWork.MainTestSetUp.INIT_PATH;

public class CheckoutAddressPagePOM extends RegistrationPagePOM{

    WebDriver driver;
    WebDriverWait wait;


    By backToSummaryPage = By.cssSelector("#order_step li:nth-of-type(1)");
    By deliveryAddressCheckbox = By.id("addressesAreEquals");
    By deliveryAddressNames = By.cssSelector("#address_delivery li:nth-of-type(2)");
    By deliveryAddressCity = By.cssSelector("#address_delivery li:nth-of-type(5)");
    By deliveryAddressCountry = By.cssSelector("#address_delivery li:nth-of-type(6)");
    By deliveryAddressPhoneNum = By.cssSelector("#address_delivery li:nth-of-type(7)");
    By deliveryAddressMobileNum = By.cssSelector("#address_delivery li:nth-of-type(8)");
    By billingAddressNames = By.cssSelector("#address_invoice li:nth-of-type(2)");
    By billingAddressCity = By.cssSelector("#address_invoice li:nth-of-type(5)");
    By billingAddressCountry = By.cssSelector("#address_invoice li:nth-of-type(6)");
    By billingAddressPhoneNum = By.cssSelector("#address_invoice li:nth-of-type(7)");
    By billingAddressMobileNum = By.cssSelector("#address_invoice li:nth-of-type(8)");
    By addNewAddressBtn = By.cssSelector("p[class='address_add submit'] > a[title='Add']");
    By commentField = By.cssSelector("[name='message']");
    By proceedToShippmentPage = By.cssSelector("[class='button btn btn-default button-medium']");

    public CheckoutAddressPagePOM() {

    }

    public CheckoutAddressPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void validateAddressFields(String email) {
        List<String> details = new ArrayList<>();
        try {
            details = ReadFromXml.UserRegistrationDetails(INIT_PATH, email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddressNames)).getText(),details.get(2)+" "+details.get(3));
        //Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddressCity)).getText(),details.get(11));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddressCountry)).getText(),details.get(14));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddressPhoneNum)).getText(),details.get(16));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddressMobileNum)).getText(),details.get(17));
    }

    public void leaveComment(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentField)).sendKeys(text);
    }

    public CheckoutShippingPagePOM proceedToShipping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToShippmentPage)).click();
        return new CheckoutShippingPagePOM(driver);
    }
}
