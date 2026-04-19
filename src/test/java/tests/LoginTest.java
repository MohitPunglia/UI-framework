package tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DataProviderUtil;
import utils.JsonReader;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginPageTitle() {
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println("Title is ------>" + title);
        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(priority = 2)
    public void performLogin() {
        HomePage homepage = page.getInstance(LoginPage.class).login(ConfigReader.get("username"),
                ConfigReader.get("password"));
        String header = homepage.getHomePageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Swag Labs");
        // Assert.assertEquals(header, "Products");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        JSONArray data = JsonReader.getJsonData();
        return DataProviderUtil.getTestData(
                data,
                "username",
                "password",
                "type");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String type) {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage.login(username, password);

        if (type.equalsIgnoreCase("valid")) {
            HomePage homePage = page.getInstance(HomePage.class);
            String header = homePage.getHomePageHeader();
            Assert.assertEquals(header, "Swag Labs");
        } else {
            String errorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(errorMessage.length() > 0, "Expected error meassage but none found");
        }

    }

}
