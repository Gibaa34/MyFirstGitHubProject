package PageObjectModel;

import com.google.common.base.Converter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPaymentPagePOM extends CheckoutShippingPagePOM {

    WebDriver driver;
    WebDriverWait wait;

    By backToShippingPage = By.cssSelector("#order_step li:nth-of-type(4)");
    By unitPrice = By.cssSelector("[data-title='Unit price']");
    By unitQuantity = By.cssSelector("[class='cart_quantity text-center']");
    By totalPriceOfProduct = By.cssSelector("[data-title='Total']");
    By totalPriceOfAllProducts = By.id("total_product");
    By totalShippingPrice = By.id("total_shipping");
    By totalPriceOfAllProductsWithShipping = By.id("total_price");
    By payByBankWireBtn = By.cssSelector("[title='Pay by bank wire']");
    By payByCheckBtn = By.cssSelector("[title='Pay by check.']");

    public CheckoutPaymentPagePOM() {

    }

    public CheckoutPaymentPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void validatePrices() throws InterruptedException {
        String productPrice = (wait.until(ExpectedConditions.visibilityOfElementLocated(unitPrice)).getText().replace("$",""));
        double productPriceD = Double.valueOf(productPrice);
        String productQuantity = (wait.until(ExpectedConditions.visibilityOfElementLocated(unitQuantity)).getText());
        int productQuantityI = Integer.valueOf(productQuantity);
        String productTotalPrice = (wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfProduct)).getText().replace("$",""));
        double productTotalPriceD = Double.valueOf(productTotalPrice);
        String allProductTotalPrice = (wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfAllProducts)).getText().replace("$",""));
        double allProductTotalPriceD = Double.valueOf(allProductTotalPrice);
        String shippingTotalPrice = (wait.until(ExpectedConditions.visibilityOfElementLocated(totalShippingPrice)).getText().replace("$",""));
        double shippingTotalPriceD = Double.valueOf(shippingTotalPrice);
        String allProductTotalPriceWithShipping = (wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceOfAllProductsWithShipping)).getText().replace("$",""));
        double allProductTotalPriceWithShippingD =Double.valueOf(allProductTotalPriceWithShipping);

        Assert.assertEquals(productTotalPriceD,productPriceD*productQuantityI,0.1);
        System.out.println(productTotalPriceD +" = "+ productPriceD*productQuantityI);
        Assert.assertEquals(allProductTotalPriceWithShippingD,allProductTotalPriceD+shippingTotalPriceD,0.1);
        System.out.println(allProductTotalPriceWithShippingD +" = "+ (allProductTotalPriceD+shippingTotalPriceD));

    }

    public void payWithBankWire() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payByBankWireBtn)).click();
    }

    public void payWithCheck() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payByCheckBtn)).click();
    }

}
