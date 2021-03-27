package PageFactoryModel;

import FrameWork.ItemDetails;
import PageObjectModel.CheckoutAddressPagePOM;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutSummaryPageFactory extends RegistrationPageFactory{

    WebDriver driver;

    @FindBy(css = "[class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToAddressPage;

    @FindBy(css = "[class='label label-success']")
    WebElement inStockLabel;

    @FindBy(css = "[class='cart_quantity_input form-control grey']")
    WebElement quantityField;

    @FindBy(css = "td[class='cart_unit'] > [class='price']")
    WebElement itemPrice;

    public CheckoutSummaryPageFactory() {

    }

    public CheckoutSummaryPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutAddressPageFactory validateValuesAndProceed(ItemDetails details) {
        inStockLabel.isDisplayed();
        Assert.assertEquals(quantityField.getAttribute("value"), details.quantity);
        Assert.assertEquals(itemPrice.getText(), details.price);
        proceedToAddressPage.click();
        return new CheckoutAddressPageFactory(driver);
    }
}
