
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginPageTitle() {
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(priority = 2)
    public void performLogin() {
        HomePage homepage = page.getInstance(LoginPage.class).login("standard_user", "secret_sauce");
        String header = homepage.getHomePageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Swag Labs");
    }

}
