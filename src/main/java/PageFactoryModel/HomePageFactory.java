package PageFactoryModel;

import FrameWork.ItemDetails;
import FrameWork.Utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePageFactory extends ItemDetails {

    private WebDriver driver;
    String email;
    //private String url = "http://automationpractice.com/index.php";

    @FindBy(className = "login")
    WebElement signInBtn;

    @FindBy(how = How.XPATH, using = "//div[@id ='contact-link']/a[@title = 'Contact us']")
    WebElement contactUsBtn;

    @FindBy(css = "[title='View my shopping cart']")
    WebElement cartBtn;

    @FindBy(css = "[alt='My Store']")
    WebElement logoImage;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(css = "[name='submit_search']")
    WebElement searchBtn;

    @FindBy(css = "[class='homefeatured']")
    WebElement popularMenu;

    @FindBy(css = "[class='blockbestsellers']")
    WebElement bestSellerMenu;

    @FindBy(id = "homepage-slider")
    WebElement homePageSlider;

    @FindBy(css = "[src*='banner-img6.jpg']")
    WebElement homePageUpRightAd;

    @FindBy(css = "[src*='banner-img7.jpg']")
    WebElement homePageDownRightAd;

    @FindBy(css = "[title='Women']")
    WebElement womenMenu;

    @FindBy(css = "[title='Dresses']")
    WebElement dressesMenu;

    @FindBy(css = "[title='T-shirts']")
    WebElement tshirtsMenu;

    @FindBy(css = "#homefeatured li:nth-of-type(1)")
    WebElement fadedShortSleeveTshirtsImgLink;

    @FindBy(css = "#homefeatured li:nth-of-type(2)")
    WebElement blouseImgLink;

    @FindBy(css = "#homefeatured li:nth-of-type(3)")
    WebElement printedDressImgLink_26_00;

    @FindBy(css = "#homefeatured li:nth-of-type(4)")
    WebElement printedDressImgLink_50_99;

    @FindBy(css = "#homefeatured li:nth-of-type(5)")
    WebElement printedSummerDressImgLink_28_98;

    @FindBy(css = "#homefeatured li:nth-of-type(6)")
    WebElement printedSummerDressImgLink_30_50;

    @FindBy(css = "#homefeatured li:nth-of-type(7)")
    WebElement printedChiffonDressImgLink;

    public HomePageFactory() {

    }

    public HomePageFactory(WebDriver driver, String email) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver == null) {
            throw new NullPointerException("Deiver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.email = email;
    }

    public void navigateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        Log.info("Open " + url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public LoginPageFactory openSingInPage() {
        signInBtn.click();
        Log.info("Opened login page");
        return new LoginPageFactory(driver, email);
    }

    public void closePage() {
        driver.close();
    }

    public ProductDetailsPageFactory openItems(String name) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(name))).click().perform();
        return new ProductDetailsPageFactory(driver);
    }

}
