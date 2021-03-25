package PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPagePOM extends LoginPagePOM {

    WebDriver driver;
    WebDriverWait wait;

    By loginForm = By.id("login_form");
    By accountInfo = By.cssSelector("[title='View my customer account']");

    By homeBtn = By.cssSelector("[title='Home']");
    By logOutBtn = By.cssSelector("[title='Log me out']");
    By orderHistoryBtn = By.cssSelector("[title='Orders']");
    By creditSlipsBtn = By.cssSelector("[title='Credit slips']");
    By addressesBtn = By.cssSelector("[title='Addresses']");
    By personalInfoBtn = By.cssSelector("[title='Information']");
    By wishlishBtn = By.cssSelector("[title='My wishlists']");

    public LoggedInPagePOM(WebDriver dr) {
        driver = dr;
        wait = new WebDriverWait(driver, 10);
        this.email = email;
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

    public void goToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularMenu));
    }
}
