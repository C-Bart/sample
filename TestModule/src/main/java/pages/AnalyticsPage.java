package pages;

import bc.artest.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalyticsPage {

    private final String pageURL = Configuration.get("baseURL") + "/analytics/list";

    public AnalyticsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-wrapper']//h3[text()=' Analityka ']")
    private WebElement analyticsHead;

    public String getPageURL() {
        return pageURL;
    }

    public WebElement getAnalyticsHead() {
        return analyticsHead;
    }
}
