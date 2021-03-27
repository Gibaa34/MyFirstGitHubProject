package PageFactoryModel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPageFactory extends LoginPageFactory{

    WebDriver driver;

    @FindBy(id = "login_form")
    WebElement loginForm;

    @FindBy(css = "[title='View my customer account']")
    WebElement accountInfo;

    @FindBy(css = "[title='Home']")
    WebElement homeBtn;

    @FindBy(css = "[title='Log me out']")
    WebElement logOutBtn;

    @FindBy(css = "[title='Orders']")
    WebElement orderHistoryBtn;

    @FindBy(css = "[title='Credit slips']")
    WebElement creditSlipsBtn;

    @FindBy(css = "[title='Addresses']")
    WebElement addressesBtn;

    @FindBy(css = "[title='Information']")
    WebElement personalInfoBtn;

    @FindBy(css = "[title='My wishlists']")
    WebElement wishlishBtn;

    public LoggedInPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAccountInfoByText(String expectedText) {
        Assert.assertEquals(expectedText, accountInfo.getText());
        System.out.println("Checking passed!");
    }

    public void logOut() {
        logOutBtn.click();
        loginForm.isDisplayed();
        System.out.println("Log out successfully!");
    }

    public void goToHomePage() {
        homeBtn.click();
        popularMenu.isDisplayed();
    }

}
