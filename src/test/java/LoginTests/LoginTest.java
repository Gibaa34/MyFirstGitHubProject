package LoginTests;

import FrameWork.MainTestSetUp;
import PageFactoryModel.HomePageFactory;
import PageFactoryModel.LoginPageFactory;
import PageObjectModel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pomLogin() {
        HomePagePOM homePage = new HomePagePOM(driver, "");
        homePage.navigateTo("");
        LoginPagePOM loginPage = homePage.openSingInPage();
        try {
            loginPage.login("plamenmanolov11@yahoo.com","alabala");
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginPage.checkAccountInfoByText("Plamen Manolov");
        loginPage.logOut();
        homePage.closePage();
    }

    /*@Test
    public void factoryLogin() {
        *//*PageFactory.initElements(driver, HomePageFactory.class);
        PageFactory.initElements(driver, LoginPageFactory.class);*//*
        HomePageFactory homePageFactory = new HomePageFactory(driver);
        homePageFactory.navigateTo();
        LoginPageFactory loginPageFactory = homePageFactory.openSingInPage();
        loginPageFactory.login("plamenmanolov11@yahoo.com","alabala");
        loginPageFactory.checkAccountInfoByText("Plamen Manolov");
        loginPageFactory.logOut();
        homePageFactory.closePage();
    }*/
}
