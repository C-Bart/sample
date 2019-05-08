package managers;

import cucumber.api.Scenario;
import io.qameta.allure.Attachment;
import bc.artest.config.Browser;
import bc.artest.config.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WebDriverManager {

    private WebDriver driver;

    WebDriverManager() throws IOException {
        Configuration.load();
        driver = Browser.setBrowserConfig(driver, "../Drivers/");
    }

    WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(Scenario scenario) {
        embedScreenshot(scenario);
        driver.close();
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            return screenshot;
        }
        return null;
    }
}
