package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait expliciteWait = new WebDriverWait(driver,3);

        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
        expliciteWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        System.out.println(driver.findElement(By.id("results")).getText());

    }
}
