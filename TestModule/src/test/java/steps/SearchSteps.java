package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.TestContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DeliveryViewPage;

public class SearchSteps {

    private TestContext testContext;
    private DeliveryViewPage deliveryViewPage;

    public SearchSteps(TestContext context) {
        testContext = context;
        deliveryViewPage = testContext.getPageObjectManager().getDeliveryViewPage();
    }

    @When("^user fill ID of the delivery$")
    public void fillDeliveryIdInFilter() {
        // TODO: replace it by dynamic id
        deliveryViewPage.getDeliveryIdInput().sendKeys("320166");
    }

    @When("^use filtering$")
    public void filtering() {
        deliveryViewPage.getSubmitFiltersButton().click();
    }

    @Then("^delivery with searching ID is on the result list$")
    public void chechIsDeliveryOnTheList() {
        WebElement deliveryList = deliveryViewPage.getDeliveryList();
        // TODO: change static id in xpath
        Assert.assertTrue(deliveryList.findElement(By.xpath(".//a[contains(text(), '320166')]")).isDisplayed());
    }

}
