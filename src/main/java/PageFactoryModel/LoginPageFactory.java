package PageFactoryModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    private WebDriver driver;

    @FindBy(id = "login_form")
    WebElement loginForm;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class = 'header_user_info']/a[@class = 'account']")
    WebElement accountInfo;

    @FindBy(xpath = "//p[@class = 'lost_password form-group']/a[@rel= 'nofollow']")
    WebElement forgotenPasswordLinkBtn;

    @FindBy(xpath = "//div[@class = 'header_user_info']/a[@class = 'logout']")
    WebElement logOutBtn;

    public LoginPageFactory(WebDriver driver) {
        if(driver==null){
            throw new NullPointerException("LPF: Driver isntance is null");
        }
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String email, String password) {
        if(validateEmail(email) && password.length()>5 && loginForm.isDisplayed()) {
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            submitBtn.click();
            System.out.println("Successfull login");
        }else {
            System.out.println("Incorect email or password entered");
        }
    }

    public void checkAccountInfoByText(String expectedText) {
        Assert.assertEquals(expectedText,accountInfo.getText());
        System.out.println("Checking passed");
    }

    public void logOut() {
       logOutBtn.click();
       if(loginForm.isDisplayed()) {
           System.out.println("Logout seccessfully");
       }else {
           throw new RuntimeException("Fail to logout from account");
       }

    }

    //validate email
    private boolean validateEmail(String em) {
        return true;
    }
}
