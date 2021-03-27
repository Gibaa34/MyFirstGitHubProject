package PageObjectModel;

import FrameWork.Utilities.ReadFromXml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static FrameWork.MainTestSetUp.INIT_PATH;

public class RegistrationPagePOM extends LoginPagePOM {

    WebDriver driver;
    WebDriverWait wait;
    protected String email;
    protected final String personXml = "D:\\Plamen\\QA\\Bin\\FrameWork.xlsx";
    //public List<String> details;

    By title = By.id("id_gender1");
    By customerFirstName = By.id("customer_firstname");
    By customerLastName = By.id("customer_lastname");
    By password = By.id("passwd");
    By birthDay = By.xpath("//select[@id='days']");
    By birthMonth = By.id("months");
    By birthYear = By.id("years");
    By newsletterCheckbox = By.id("newsletter");
    By specialOfferCheckbox = By.id("optin");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By company = By.id("company");
    By address = By.id("address1");
    By secondaryAddress = By.id("address2");
    By city = By.id("city");
    By state = By.id("id_state");
    By zipPostalCode = By.id("postcode");
    By country = By.id("id_country");
    By additionalInfo = By.id("other");
    By homePhone = By.id("phone");
    By mobilePhone = By.id("phone_mobile");
    By addressAlies = By.id("alias");
    By registerBtn = By.id("submitAccount");

    public RegistrationPagePOM() {

    }

    public RegistrationPagePOM(WebDriver driver, String email) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        this.email = email;
    }

    public LoggedInPagePOM register() {
        List<String> details = new ArrayList<>();
        try {
            details = ReadFromXml.UserRegistrationDetails(INIT_PATH, email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(title)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerFirstName)).sendKeys(details.get(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerLastName)).sendKeys(details.get(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(details.get(4));
        Select birthDaySelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(birthDay)));
        birthDaySelect.selectByValue(details.get(5));
        Select birthMonthSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(birthMonth)));
        birthMonthSelect.selectByValue(details.get(6));
        Select birthYearSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(birthYear)));
        birthYearSelect.selectByValue(details.get(7));
        WebElement newsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(newsletterCheckbox));
        if (!newsCheckbox.isSelected()) {
            newsCheckbox.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(company)).sendKeys(details.get(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(details.get(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys(details.get(11));
        Select stateSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(state)));
        stateSelect.selectByValue(details.get(12));
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipPostalCode)).sendKeys(details.get(13));
        wait.until(ExpectedConditions.visibilityOfElementLocated(additionalInfo)).sendKeys(details.get(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePhone)).sendKeys(details.get(16));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhone)).sendKeys(details.get(17));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressAlies)).sendKeys(details.get(18));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn)).click();

        return new LoggedInPagePOM(driver);
    }
}
