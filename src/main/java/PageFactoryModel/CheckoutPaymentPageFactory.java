package PageFactoryModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPaymentPageFactory extends CheckoutShippingPageFactory{

    WebDriver driver;

    @FindBy(css = "#order_step li:nth-of-type(4)")
    WebElement backToShippingPage;

    @FindBy(css = "[data-title='Unit price']")
    WebElement unitPrice;

    @FindBy(css = "[class='cart_quantity text-center']")
    WebElement unitQuantity;

    @FindBy(css = "[data-title='Total']")
    WebElement totalPriceOfProduct;

    @FindBy(id = "total_product")
    WebElement totalPriceOfAllProducts;

    @FindBy(id = "total_shipping")
    WebElement totalShippingPrice;

    @FindBy(id = "total_price")
    WebElement totalPriceOfAllProductsWithShipping;

    @FindBy(css = "[title='Pay by bank wire']")
    WebElement payByBankWireBtn;

    @FindBy(css = "[title='Pay by check.']")
    WebElement payByCheckBtn;

    public CheckoutPaymentPageFactory() {

    }

    public CheckoutPaymentPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validatePrices() throws InterruptedException {
        String productPrice = (unitPrice.getText().replace("$",""));
        double productPriceD = Double.valueOf(productPrice);
        String productQuantity = (unitQuantity.getText());
        int productQuantityI = Integer.valueOf(productQuantity);
        String productTotalPrice = (totalPriceOfProduct.getText().replace("$",""));
        double productTotalPriceD = Double.valueOf(productTotalPrice);
        String allProductTotalPrice = (totalPriceOfAllProducts.getText().replace("$",""));
        double allProductTotalPriceD = Double.valueOf(allProductTotalPrice);
        String shippingTotalPrice = (totalShippingPrice.getText().replace("$",""));
        double shippingTotalPriceD = Double.valueOf(shippingTotalPrice);
        String allProductTotalPriceWithShipping = (totalPriceOfAllProductsWithShipping.getText().replace("$",""));
        double allProductTotalPriceWithShippingD =Double.valueOf(allProductTotalPriceWithShipping);

        Assert.assertEquals(productTotalPriceD,productPriceD*productQuantityI,0.1);
        System.out.println(productTotalPriceD +" = "+ productPriceD*productQuantityI);
        Assert.assertEquals(allProductTotalPriceWithShippingD,allProductTotalPriceD+shippingTotalPriceD,0.1);
        System.out.println(allProductTotalPriceWithShippingD +" = "+ (allProductTotalPriceD+shippingTotalPriceD));

    }

    public void payWithBankWire() {
        payByBankWireBtn.click();
    }

    public void payWithCheck() {
        payByCheckBtn.click();
    }
}
