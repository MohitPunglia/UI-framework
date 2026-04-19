package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    public WebDriver driver;
    public WebDriverWait wait;

    // constructor
    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract void waitForElement(By locator);

    public abstract WebElement getElement(By locator);

    // public abstract String getHeader(By locator);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("###### Error Occured Here #########");
        }
        return null;
    }

}
