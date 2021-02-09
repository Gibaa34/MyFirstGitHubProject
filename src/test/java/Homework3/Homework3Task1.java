package Homework3;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework3Task1 {

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

    @Test
    public void missingNamesTest() {
        String email = "plamenmanolov11@yahoo.com";
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("passwd")).sendKeys("alabala");

        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("5");
        Select selectMonth = new Select(driver.findElement(By.cssSelector("[name='months']")));
        selectMonth.selectByIndex(6);
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue("1986");

        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement box : checkbox) {
            if (box.isSelected()) {
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        driver.findElement(By.id("address1")).sendKeys("bul \"6th september №126\"");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Plovdiv");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        selectCountry.selectByIndex(1);
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.name("phone_mobile")).sendKeys("0885259879");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println(errorMessage.getText());
    }

    @Test
    public void missingPasswordTest() {
        String email = "plamenmanolov11@yahoo.com";
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("Plamen");
        driver.findElement(By.cssSelector("input[name='customer_lastname']")).sendKeys("Manolov");

        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("5");
        Select selectMonth = new Select(driver.findElement(By.cssSelector("[name='months']")));
        selectMonth.selectByIndex(6);
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue("1986");

        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement box : checkbox) {
            if (box.isSelected()) {
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        driver.findElement(By.id("address1")).sendKeys("bul \"6th september №126\"");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Plovdiv");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        selectCountry.selectByIndex(1);
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.name("phone_mobile")).sendKeys("0885259879");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println(errorMessage.getText());
    }

    @Test
    public void missingCityAddressTest() {
        String email = "plamenmanolov11@yahoo.com";
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

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
            if (box.isSelected()) {
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        Select selectState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        selectCountry.selectByIndex(1);
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.name("phone_mobile")).sendKeys("0885259879");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println(errorMessage.getText());
    }

    @Test
    public void missingCountryTest() {
        String email = "plamenmanolov11@yahoo.com";
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

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
            if (box.isSelected()) {
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        driver.findElement(By.id("address1")).sendKeys("bul \"6th september №126\"");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Plovdiv");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        driver.findElement(By.name("phone_mobile")).sendKeys("0885259879");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println(errorMessage.getText());
    }

    @Test
    public void missingPhoneTest() {
        String email = "plamenmanolov11@yahoo.com";
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[class='login']")).click();
        WebElement locatorEmail = driver.findElement(By.id("email_create"));
        locatorEmail.sendKeys(email);
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

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
            if (box.isSelected()) {
                System.out.println("Checkbox is already selected");
            } else {
                box.click();
            }
        }

        driver.findElement(By.id("address1")).sendKeys("bul \"6th september №126\"");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Plovdiv");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("40000");
        Select selectCountry = new Select(driver.findElement(By.id("id_country")));
        selectCountry.selectByIndex(0);
        selectCountry.selectByIndex(1);
        selectState.selectByVisibleText("Florida");
        driver.findElement(By.cssSelector("button[id='submitAccount']")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        System.out.println(errorMessage.getText());
    }
}