package UITest;

import BaseUI.BaseTest;
import Pages.LoginPage;
import Pages.RequestPage;
import org.testng.annotations.Test;

public class RequestPageTest extends BaseTest {

    @Test
    public void HomePageLoadCorrectly() {
        LoginPage loginPage = new LoginPage(driver);
        RequestPage requestPage = new RequestPage(driver);

        loginPage.navigateToLoginPage()
                .waitForPageLoad()
                .loginWithCredentials("admin@test.com","test123");
        requestPage.waitForPageLoad()
                .verifyNumberOfApproveRequstByYear("2019",5);
    }
}