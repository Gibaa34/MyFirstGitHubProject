package PageFactoryModel;

import FrameWork.Utilities.Log;
import FrameWork.Utilities.ScreenShooter;
import PageObjectModel.RegistrationPagePOM;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPageFactory extends HomePageFactory {

    WebDriver driver;

    @FindBy(id = "login_form")
    WebElement loginForm;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInBtn;

    @FindBy(xpath = "//div[@class = 'header_user_info']/a[@class = 'account']")
    WebElement accountInfo;

    @FindBy(xpath = "//p[@class = 'lost_password form-group']/a[@rel= 'nofollow']")
    WebElement forgottenPasswordLinkBtn;

    @FindBy(css = "[title='Log me out']")
    WebElement logOutBtn;

    @FindBy(id = "email_create")
    WebElement createAccountEmailField;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @FindBy(css = "[title='Home']")
    WebElement homeBtn;

    public LoginPageFactory() {

    }


    public LoginPageFactory(WebDriver driver, String email) {
        if (driver == null) {
            throw new NullPointerException("LPF: Driver instance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.email = email;
    }

    public void login(String email, String password) throws IOException {
        if (validateEmail(email) && password.length() > 5 && loginForm.isDisplayed()) {
            ScreenShooter.takeWebElementScreenShot((loginForm),"LoginFormFactory");
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            Log.info("Login with username: " + email + " - password: " + password);
            signInBtn.click();
            System.out.println("Successfull login!");
        } else {
            Log.error("Incorect email or password entered!");
            System.out.println("Incorect email or password entered!");
            throw new IllegalArgumentException("Incorect email or password entered!");
        }
    }

    public void checkAccountInfoByText(String expectedText) {
        Assert.assertEquals(expectedText, accountInfo.getText());
        System.out.println("Checking passed");
    }

    public void logOut() {
        logOutBtn.click();
        if (loginForm.isDisplayed()) {
            System.out.println("Logout seccessfully");
        } else {
            throw new RuntimeException("Fail to logout from account");
        }
    }

    private boolean validateEmail(String em) {
        return true;
    }

    public RegistrationPageFactory createAnAccount(String email) {
        createAccountEmailField.sendKeys(email);
        createAccountBtn.click();
        Log.info("Opened registration page");
        return new RegistrationPageFactory(driver, email);
    }

    public void goToHomePage() {
        homeBtn.click();
        popularMenu.isDisplayed();
    }
}
