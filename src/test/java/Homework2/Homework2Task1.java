package Homework2;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2Task1 {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("user-data-dir=/path/to/your/custom/profile");
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    //Първа задача
    @Test
    public void testing() {

        String title = "SeleniumHQ Browser Automation";
        driver.get("https://www.google.com/");
        WebElement locatorSearch = driver.findElement(By.cssSelector("[name='q']"));
        locatorSearch.click();
        locatorSearch.sendKeys("Selenium");
        locatorSearch.submit();

        driver.findElement(By.cssSelector("[id='search'] [class='yuRUbf']")).click();
        System.out.println(driver.getCurrentUrl().equals("https://www.selenium.dev/"));

        Assert.assertEquals(title,driver.getTitle());
    }

    //Втора задача
    @Test
    public void testing2() throws InterruptedException {

        String email = "plamenmanolov11@yahoo.com";
        String verifyMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
        String fieldEmail = driver.findElement(By.cssSelector("[data-validate='isEmail']")).getAttribute("value");
        //System.out.println(fieldEmail);
        Assert.assertEquals(email,fieldEmail);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("Plamen");
        driver.findElement(By.cssSelector("input[name='customer_lastname']")).sendKeys("Manolov");
        driver.findElement(By.id("passwd")).sendKeys("alabala");

        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("5");
        Select selectMonth = new Select(driver.findElement(By.cssSelector("[name='months']")));
        selectMonth.selectByIndex(6);
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue("1986");

        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement box : checkbox) {
            if (box.isSelected()){
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        driver.findElement(By.id("address1")).sendKeys("bul \"6th september №126\"");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Plovdiv");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        selectCountry.selectByIndex(1);
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.name("phone_mobile")).sendKeys("0885259879");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        String message = driver.findElement(By.cssSelector("p[class='info-account']")).getText();
        System.out.println(message);
        Assert.assertEquals(verifyMessage,message);

        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }


}
