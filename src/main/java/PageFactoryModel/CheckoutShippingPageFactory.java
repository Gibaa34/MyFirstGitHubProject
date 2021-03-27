package PageFactoryModel;

import PageObjectModel.CheckoutPaymentPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutShippingPageFactory extends  CheckoutAddressPageFactory{

    WebDriver driver;

    @FindBy(css = "#order_step li:nth-of-type(3)")
    WebElement backToAddressPage;

    @FindBy(css = "input[class='delivery_option_radio']")
    WebElement deliveryRadioBtn;

    @FindBy(css = "div[class='delivery_option_price']")
    WebElement deliveryPrice;

    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckbox;

    @FindBy(css = "[class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToPaymentPage;

    public CheckoutShippingPageFactory() {

    }

    public CheckoutShippingPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPaymentPageFactory acceptAndProceed() {
        if (!termsOfServiceCheckbox.isSelected()) {
            termsOfServiceCheckbox.click();
        }
        proceedToPaymentPage.click();
        return new CheckoutPaymentPageFactory(driver);
    }
}
