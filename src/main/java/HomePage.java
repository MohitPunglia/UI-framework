import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By header = By.className("//*[@class='app_logo']");

    public WebElement getHeader() {
        return getElement(header);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public String getHomePageHeader() {
        return getPageHeader(header);
    }

}
