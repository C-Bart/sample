package steps;

import cucumber.api.Scenario;
import managers.TestContext;
import cucumber.api.java.After;
import bc.artest.allure.GenEnv;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public void tearDown(Scenario scenario) {
        testContext.getWebDriverManager().closeDriver(scenario);

        // TODO: shouldn't be here
        GenEnv.createEnvFile("environment");
    }

}
