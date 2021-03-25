package PageObjectModel;

import FrameWork.ItemDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.StandardWatchEventKinds;

public class ProductDetailsPagePOM extends HomePagePOM{

    WebDriver driver;
    WebDriverWait wait;

    By itemName = By.cssSelector("[itemprop='name']");
    By itemPrice = By.id("our_price_display");
    By itemQuantityField = By.id("quantity_wanted");
    By quantityMinusBtn = By.cssSelector("[class='btn btn-default button-minus product_quantity_down']");
    By quantityPlusBtn = By.cssSelector("[class='btn btn-default button-plus product_quantity_up']");
    By itemSize = By.id("group_1");
    By orangeColor = By.id("color_13");
    By blueColor = By.id("color_14");
    By whiteColor = By.id("color_8");
    By blackColor = By.id("color_11");
    By beigeColor = By.id("color_7");
    By pinkColor = By.id("color_24");
    By yellowColor = By.id("color_16");
    By greenColor = By.id("color_15");
    By addToCartBtn = By.cssSelector("[class='exclusive']");
    By itemBigPicture = By.id("bigpic");

    By addToWishlist = By.id("wishlist_button");
    By proceedToCheckout = By.cssSelector("[class='btn btn-default button button-medium']");
    By continueShopping = By.cssSelector("[class='continue btn btn-default button exclusive-medium']");


    public ProductDetailsPagePOM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    public void addToCart(ItemDetails details) throws InterruptedException {
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(itemQuantityField));
        quantity.clear();
        Thread.sleep(1000);
        quantity.sendKeys(details.quantity);
        Select size = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(itemSize)));
        size.selectByVisibleText(details.size);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(details.color))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
    }

    public void continueShopping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).click();
    }

    public CheckoutSummaryPagePOM proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout)).click();
        return new CheckoutSummaryPagePOM(driver);
    }
}
