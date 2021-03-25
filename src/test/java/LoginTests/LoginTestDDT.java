package LoginTests;

import FrameWork.MainTestSetUp;
import FrameWork.Utilities.Log;
import FrameWork.Utilities.ScreenShooter;
import PageObjectModel.HomePagePOM;
import PageObjectModel.LoginPagePOM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginTestDDT extends MainTestSetUp {

    @Before
    public void setUp() {
        try {
            this.mainSetUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        mainTestTearDown();
    }

    @Test
    public void simpleLogin() throws IOException {
        try {
            Log.startTestDetails(this.getClass().getSimpleName());
            Log.info("Open Homepage");
            HomePagePOM homePage = new HomePagePOM(driver, this.getUsername());
            homePage.navigateTo(this.getMainURL());
            LoginPagePOM loginPage = homePage.openSingInPage();
            BufferedImage image1 = ScreenShooter.takePageScreenshot(this.driver, "Login");
            BufferedImage imageOut = ImageIO.read(new File("D:\\Plamen\\QA\\Bin\\TestingScreenshots\\LoginImage.png"));
            ScreenShooter.compareImages(image1, imageOut);
            loginPage.login(this.getUsername(), this.getPassword());
            loginPage.checkAccountInfoByText(this.getLoggedUserInfo());
            loginPage.logOut();
            homePage.closePage();
        } catch (RuntimeException exception){
            Log.error(exception.getMessage());
            throw exception;
        }
    }
}
