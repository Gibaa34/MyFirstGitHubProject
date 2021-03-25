package PageObjectModel;

import FrameWork.ItemDetails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutSummaryPagePOM extends RegistrationPagePOM {

    WebDriver driver;
    WebDriverWait wait;

    By proceedToAddressPage = By.cssSelector("[class='button btn btn-default standard-checkout button-medium']");
    By inStockLabel = By.cssSelector("[class='label label-success']");
    By quantityField = By.cssSelector("[class='cart_quantity_input form-control grey']");
    By itemPrice = By.cssSelector("td[class='cart_unit'] > [class='price']");

    public CheckoutSummaryPagePOM() {

    }

    public CheckoutSummaryPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public CheckoutAddressPagePOM validateValuesAndProceed(ItemDetails details) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inStockLabel));
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField)).getAttribute("value"), details.quantity);
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice)).getText(), details.price);
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToAddressPage)).click();
        return new CheckoutAddressPagePOM(driver);
    }

}
