package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class RequestPage extends BasePage {
    private WebDriver driver;

    public RequestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "img[alt='logo']")
    private WebElement logoImg;

    public RequestPage waitForPageLoad() {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(logoImg);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(condition);
        return this;
    }

    private List<WebElement> getApproveRequestByYear(String year) {
        String selector = "//td[contains(@class,'td-request-approve')]/following-sibling::td[1]/div[contains(text(),'/"+year+"')]";
        return driver.findElements(By.xpath(selector));
    }

    public void verifyNumberOfApproveRequstByYear(String year, int expectedRequests) {
        Assert.assertEquals(getApproveRequestByYear("2019").size(), expectedRequests);
    }
}
