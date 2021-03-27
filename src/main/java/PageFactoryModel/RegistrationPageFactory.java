package PageFactoryModel;

import FrameWork.Utilities.ReadFromXml;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static FrameWork.MainTestSetUp.INIT_PATH;

public class RegistrationPageFactory extends LoginPageFactory {

    WebDriver driver;
    protected String email;
    protected final String personXml = "D:\\Plamen\\QA\\Bin\\FrameWork.xlsx";
    //public List<String> details;

    @FindBy(id = "id_gender1")
    WebElement title;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement birthDay;

    @FindBy(id = "months")
    WebElement birthMonth;

    @FindBy(id = "years")
    WebElement birthYear;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOfferCheckbox;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "address2")
    WebElement secondaryAddress;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement zipPostalCode;

    @FindBy(id = "id_country")
    WebElement country;

    @FindBy(id = "other")
    WebElement additionalInfo;

    @FindBy(id = "phone")
    WebElement homePhone;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement addressAlies;

    @FindBy(id = "submitAccount")
    WebElement registerBtn;

    public RegistrationPageFactory() {

    }

    public RegistrationPageFactory(WebDriver driver, String email) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.email = email;
    }

    public LoggedInPageFactory register() throws InterruptedException {
        List<String> details = new ArrayList<>();
        try {
            details = ReadFromXml.UserRegistrationDetails(INIT_PATH, email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        title.click();
        customerFirstName.sendKeys(details.get(2));
        customerLastName.sendKeys(details.get(3));
        password.sendKeys(details.get(4));
        Select birthDaySelect = new Select(birthDay);
        birthDaySelect.selectByValue(details.get(5));
        Select birthMonthSelect = new Select(birthMonth);
        birthMonthSelect.selectByValue(details.get(6));
        Select birthYearSelect = new Select(birthYear);
        birthYearSelect.selectByValue(details.get(7));
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
        company.sendKeys(details.get(8));
        address.sendKeys(details.get(9));
        city.sendKeys(details.get(11));
        Select stateSelect = new Select(state);
        stateSelect.selectByValue(details.get(12));
        zipPostalCode.sendKeys(details.get(13));
        additionalInfo.sendKeys(details.get(15));
        homePhone.sendKeys(details.get(16));
        mobilePhone.sendKeys(details.get(17));
        addressAlies.sendKeys(details.get(18));
        registerBtn.click();

        return new LoggedInPageFactory(driver);
    }
}
