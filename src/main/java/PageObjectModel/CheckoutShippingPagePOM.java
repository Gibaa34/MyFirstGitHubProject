package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutShippingPagePOM extends CheckoutAddressPagePOM{

    WebDriver driver;
    WebDriverWait wait;

    By backToAddressPage = By.cssSelector("#order_step li:nth-of-type(3)");
    By deliveryRadioBtn = By.cssSelector("input[class='delivery_option_radio']");
    By deliveryPrice = By.cssSelector("div[class='delivery_option_price']");
    By termsOfServiceCheckbox = By.id("cgv");
    By proceedToPaymentPage = By.cssSelector("[class='button btn btn-default standard-checkout button-medium']");

    public CheckoutShippingPagePOM() {

    }

    public CheckoutShippingPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        this.email = email;
    }

    public CheckoutPaymentPagePOM acceptAndProceed() {
        WebElement acceptTerms = wait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceCheckbox));
        if (!acceptTerms.isSelected()) {
            acceptTerms.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToPaymentPage)).click();
        return new CheckoutPaymentPagePOM(driver);
    }

}
