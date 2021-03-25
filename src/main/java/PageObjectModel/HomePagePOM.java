package PageObjectModel;

import FrameWork.ItemDetails;
import FrameWork.Utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePagePOM extends ItemDetails{

    private WebDriver driver;
    private WebDriverWait wait;
    String email;
    //private String url = "http://automationpractice.com/index.php";

    By signInBtn = By.cssSelector("[title='Log in to your customer account']");
    By contactUsBtn = By.cssSelector("[title='Contact Us']");
    By cartBtn = By.cssSelector("[title='View my shopping cart']");
    By logoImage = By.cssSelector("[alt='My Store']");
    By searchField = By.id("search_query_top");
    By searchBtn = By.cssSelector("[name='submit_search']");
    By popularMenu = By.cssSelector("[class='homefeatured']");
    By bestSellerMenu = By.cssSelector("[class='blockbestsellers']");
    By homePageSlider = By.id("homepage-slider");
    By homePageUpRightAd = By.cssSelector("[src*='banner-img6.jpg']");
    By homePageDownRightAd = By.cssSelector("[src*='banner-img7.jpg']");
    By womenMenu = By.cssSelector("[title='Women']");
    By dressesMenu = By.cssSelector("[title='Dresses']");
    By tshirtsMenu = By.cssSelector("[title='T-shirts']");
    By fadedShortSleeveTshirtsImgLink = By.cssSelector("#homefeatured li:nth-of-type(1)");
    By blouseImgLink = By.cssSelector("#homefeatured li:nth-of-type(2)");
    By printedDressImgLink_26_00 = By.cssSelector("#homefeatured li:nth-of-type(3)");
    By printedDressImgLink_50_99 = By.cssSelector("#homefeatured li:nth-of-type(4)");
    By printedSummerDressImgLink_28_98 = By.cssSelector("#homefeatured li:nth-of-type(5)");
    By printedSummerDressImgLink_30_50 = By.cssSelector("#homefeatured li:nth-of-type(6)");
    By printedChiffonDressImgLink = By.cssSelector("#homefeatured li:nth-of-type(7)");

    public HomePagePOM() {

    }

    public HomePagePOM(WebDriver driver, String email) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        this.email = email;
    }

    public void navigateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        Log.info("Open " + url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public LoginPagePOM openSingInPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn)).click();
        Log.info("Opened login page");
        return new LoginPagePOM(driver, email);

    }

    public void closePage() {
        driver.close();
    }

    public ProductDetailsPagePOM openItems(String name) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(name)))).click().perform();
        return new ProductDetailsPagePOM(driver);
    }
}
