package steps;

import cucumber.api.java.en.Then;
import managers.TestContext;
import org.junit.Assert;
import pages.AddNewDeliveryPage;
import pages.AnalyticsPage;
import pages.DeliveryViewPage;
import pages.OrdersPage;

public class AvailabilitySteps {

    private TestContext testContext;
    private DeliveryViewPage deliveryViewPage;
    private AddNewDeliveryPage addNewDeliveryPage;
    private OrdersPage ordersPage;
    private AnalyticsPage analyticsPage;

    public AvailabilitySteps(TestContext context) {
        testContext = context;
        deliveryViewPage = testContext.getPageObjectManager().getDeliveryViewPage();
        addNewDeliveryPage = testContext.getPageObjectManager().getAddNewDeliveryPage();
        ordersPage = testContext.getPageObjectManager().getOrdersPage();
        analyticsPage = testContext.getPageObjectManager().getAnalyticsPage();
    }

    @Then("^user has access to the delivery filter$")
    public void isFilterAvailable() {
        testContext.getPageObjectManager().getDriver().get(deliveryViewPage.getPageURL());
        Assert.assertTrue(deliveryViewPage.getFilterDeliveryPanelHeading().isDisplayed());
    }

    @Then("^user has access to the form to add new delivery$")
    public void isAddDeliveryFormAvailable() {
        testContext.getPageObjectManager().getDriver().get(addNewDeliveryPage.getPageUrl());
        Assert.assertTrue(addNewDeliveryPage.getAddDeliveryPanelHead().isDisplayed());
    }

    @Then("^user has access to orders$")
    public void isOrderFilterAvailable() {
        testContext.getPageObjectManager().getDriver().get(ordersPage.getPageUrl());
        Assert.assertTrue(ordersPage.getOrdersFilterPanelHeading().isDisplayed());
    }

    @Then("^user has access to analytics section$")
    public void isAnalyticsAvailable() {
        testContext.getPageObjectManager().getDriver().get(analyticsPage.getPageURL());
        Assert.assertTrue(analyticsPage.getAnalyticsHead().isDisplayed());
    }
}
