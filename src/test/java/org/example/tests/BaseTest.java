package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.example.util.ConfProperties;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static LoginPage loginPage;

    public static WebDriver driver;

    @Before
    public void start() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfProperties.getProperty("link"));

        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
