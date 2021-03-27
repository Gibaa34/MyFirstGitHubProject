package PageFactoryModel;

import FrameWork.ItemDetails;
import PageObjectModel.CheckoutSummaryPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPageFactory extends HomePageFactory{

    WebDriver driver;

    @FindBy(css = "[itemprop='name']")
    WebElement itemName;

    @FindBy(id = "our_price_display")
    WebElement itemPrice;

    @FindBy(id = "quantity_wanted")
    WebElement itemQuantityField;

    @FindBy(css = "[class='btn btn-default button-minus product_quantity_down']")
    WebElement quantityMinusBtn;

    @FindBy(css = "[class='btn btn-default button-plus product_quantity_up']")
    WebElement quantityPlusBtn;

    @FindBy(id = "group_1")
    WebElement itemSize;

    @FindBy(id = "color_13")
    WebElement orangeColor;

    @FindBy(id = "color_14")
    WebElement blueColor;

    @FindBy(id = "color_8")
    WebElement whiteColor;

    @FindBy(id = "color_11")
    WebElement blackColor;

    @FindBy(id = "color_7")
    WebElement beigeColor;

    @FindBy(id = "color_24")
    WebElement pinkColor;

    @FindBy(id = "color_16")
    WebElement yellowColor;

    @FindBy(id = "color_15")
    WebElement greenColor;

    @FindBy(css = "[class='exclusive']")
    WebElement addToCartBtn;

    @FindBy(id = "bigpic")
    WebElement itemBigPicture;

    @FindBy(id = "wishlist_button")
    WebElement addToWishlist;

    @FindBy(css = "[class='btn btn-default button button-medium']")
    WebElement proceedToCheckout;

    @FindBy(css = "[class='continue btn btn-default button exclusive-medium']")
    WebElement continueShopping;

    public ProductDetailsPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart(ItemDetails details) throws InterruptedException {
        itemQuantityField.clear();
        Thread.sleep(1000);
        itemQuantityField.sendKeys(details.quantity);
        Select size = new Select(itemSize);
        size.selectByVisibleText(details.size);
        driver.findElement(By.name(details.color)).click();
        addToCartBtn.click();
    }

    public void continueShopping() {
        continueShopping.click();
    }

    public CheckoutSummaryPageFactory proceedToCheckout() {
        proceedToCheckout.click();
        return new CheckoutSummaryPageFactory(driver);
    }
}
