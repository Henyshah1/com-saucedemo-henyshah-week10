package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        String baseUrl = "https://www.saucedemo.com/";
        //launch the Chrome Browser


        //open the URL into b
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);

        //Get the tittle of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get current URL
        System.out.println("The current url : " + driver.getCurrentUrl());

        //Get page source
        System.out.println(driver.getPageSource());

        String loginUrl = "https://www.saucedemo.com/";

        driver.navigate().to(loginUrl);
        System.out.println("Get current Url " + driver.getCurrentUrl());
        Thread.sleep(5000);
        //find email field element and type the email
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("abc123@gmail.com");
        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("abc123");
        Thread.sleep(5000);

        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        login.click();

        //Get current URL
        System.out.println("The current url : " + driver.getCurrentUrl());

        driver.navigate().to(baseUrl);

        //refresh
        Thread.sleep(5000);
        driver.navigate().refresh();

        //close
        driver.quit();


    }
}
