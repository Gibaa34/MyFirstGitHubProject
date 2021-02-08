package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Plamen\\QA\\Bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iter = windows.iterator();
        String parentId = iter.next();
        String childId = iter.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

    }
}
