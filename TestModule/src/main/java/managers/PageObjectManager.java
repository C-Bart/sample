package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private DeliveryViewPage deliveryViewPage;
    private AddNewDeliveryPage addNewDeliveryPage;
    private OrdersPage ordersPage;
    private AnalyticsPage analyticsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public DeliveryViewPage getDeliveryViewPage() {
        return (deliveryViewPage == null) ? deliveryViewPage = new DeliveryViewPage(driver) : deliveryViewPage;
    }

    public AddNewDeliveryPage getAddNewDeliveryPage() {
        return (addNewDeliveryPage == null) ? addNewDeliveryPage = new AddNewDeliveryPage(driver) : addNewDeliveryPage;
    }

    public OrdersPage getOrdersPage() {
        return (ordersPage == null) ? ordersPage = new OrdersPage(driver) : ordersPage;
    }

    public AnalyticsPage getAnalyticsPage() {
        return (analyticsPage == null) ? analyticsPage = new AnalyticsPage(driver) : analyticsPage;
    }
}
