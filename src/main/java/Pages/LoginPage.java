package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    WebElement usernameTxtFld;
    @FindBy(name = "password")
    WebElement passwordTxtFld;
    @FindBy(css = ".col-login__btn")
    WebElement loginBtn;

    public LoginPage navigateToLoginPage() {
        driver.get("http://ktvn-test.s3-website.us-east-1.amazonaws.com/");
        return this;
    }

    public LoginPage waitForPageLoad() {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(loginBtn);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(condition);
        return this;
    }

    public void typeUsername(String username) {
        usernameTxtFld.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordTxtFld.sendKeys(password);
    }

    public void loginWithCredentials(String username, String password) {
        typeUsername(username);
        typePassword(password);
        loginBtn.click();
    }

}