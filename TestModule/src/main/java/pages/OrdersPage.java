package pages;

import bc.artest.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

    private final String pageUrl = Configuration.get("baseURL") + "/order/list/item";

    public OrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-wrapper']//h3[contains(text(), ' Zamówienia ')]")
    private WebElement ordersFilterPanelHeading;

    public WebElement getOrdersFilterPanelHeading() {
        return ordersFilterPanelHeading;
    }

    public String getPageUrl() {
        return pageUrl;
    }
}
