package PageObjectModel;

import FrameWork.Utilities.Log;
import FrameWork.Utilities.ScreenShooter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPagePOM extends HomePagePOM {

    WebDriver driver;
    WebDriverWait wait;

    By loginForm = By.id("login_form");
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By signInBtn = By.id("SubmitLogin");
    By accountInfo = By.xpath("//div[@class = 'header_user_info']/a[@class = 'account']");
    By forgotenPasswordLinkBtn = By.xpath("//p[@class = 'lost_password form-group']/a[@rel= 'nofollow']");
    By logOutBtn = By.cssSelector("[title='Log me out']");
    By createAccountEmailField = By.id("email_create");
    By createAccountBtn = By.id("SubmitCreate");
    By homeBtn = By.cssSelector("[title='Home']");

    public LoginPagePOM() {

    }

    public LoginPagePOM(WebDriver dr, String email) {
        driver = dr;
        wait = new WebDriverWait(driver, 10);
        this.email = email;
    }

    public void login(String email, String password) throws IOException {

        if (validateEmail(email) && password.length() > 5) {
            ScreenShooter.takeWebElementScreenShot(wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm)),
                    "LoginForm");
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
            Log.info("Login with username: " + email + " - password: " + password);
            wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn)).click();
            System.out.println("Successfull login!");
        } else {
            Log.error("Incorect email or password entered!");
            System.out.println("Incorect email or password entered!");
            throw new IllegalArgumentException("Incorect email or password entered!");
        }
    }

    public void checkAccountInfoByText(String expectedText) {
        WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfo));
        Assert.assertEquals(expectedText, check.getText());
        System.out.println("Checking passed!");
    }

    public void logOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        System.out.println("Log out successfully!");
    }

    private boolean validateEmail(String em) {
        return true;
    }

    public RegistrationPagePOM createAnAccount(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountEmailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountBtn)).click();
        Log.info("Opened registration page");
        return new RegistrationPagePOM(driver, email);
    }

    public void goToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularMenu));
    }
}
