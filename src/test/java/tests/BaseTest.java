package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.Page;
import utils.ConfigReader;

public class BaseTest {

     WebDriver driver;
    public Page page;

    @BeforeMethod
    @Parameters(value = { "browser" })
    public void setUpTest(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();

            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false); // 🔥 important

            options.setExperimentalOption("prefs", prefs);

            // 🚀 ADD THESE (critical)
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito"); // avoids stored credentials
            options.addArguments("--disable-save-password-bubble");

            // optional but useful
            options.addArguments("--disable-infobars");

            driver = new ChromeDriver(options);

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("No browser found, please try with correct browser");
        }

        // driver.get("https://www.saucedemo.com/");
        driver.get(ConfigReader.get("url"));

        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
