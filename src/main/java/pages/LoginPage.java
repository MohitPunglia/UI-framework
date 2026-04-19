package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("user-name");

    private By password = By.id("password");

    private By loginBtn = By.id("login-button");

    private By errorMsg = By.xpath("//*[@class='error-message-container error']");

    private By loginLogo = By.xpath("//*[@class='login_logo']");

    public WebElement getUsername() {
        return getElement(username);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginBtn() {
        return getElement(loginBtn);
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }

    public HomePage login(String name, String pass) {
        getUsername().sendKeys(name);
        getPassword().sendKeys(pass);
        getLoginBtn().click();

        return getInstance(HomePage.class);
    }

    public void login(String name) {
        getUsername().sendKeys(name);
        getLoginBtn().click();
    }

    public String getErrorMessage() {
        return getPageHeader(errorMsg);
    }

}
