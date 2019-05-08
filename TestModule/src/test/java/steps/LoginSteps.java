package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.TestContext;
import bc.artest.config.Configuration;
import org.junit.Assert;
import pages.DeliveryViewPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private DeliveryViewPage deliveryViewPage;
    private TestContext testContext;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = context.getPageObjectManager().getLoginPage();
        deliveryViewPage = testContext.getPageObjectManager().getDeliveryViewPage();
    }

    @When("^user fill login form correctly$")
    public void correctFillLoginForm() {
        testContext.getPageObjectManager().getDriver().get(loginPage.getBaseURL());
        loginPage.fillLoginInput(Configuration.get("Login"));
        loginPage.fillPasswordInput(Configuration.get("Password"));
        loginPage.submitLoginForm();
    }

    @Then("^user has access to the TestModule$")
    public void isUserCorrectLogIn() {
        Assert.assertTrue(deliveryViewPage.getLogOutButon().isDisplayed());
    }

}