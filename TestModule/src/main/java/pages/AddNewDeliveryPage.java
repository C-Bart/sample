package pages;

import bc.artest.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewDeliveryPage {

    private final String pageUrl = Configuration.get("baseURL") + "/delivery/add";

    public AddNewDeliveryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-wrapper']//h3[text()=' Dodaj nową  dostawę ']")
    private WebElement addDeliveryPanelHead;

    @FindBy(id = "incoming_delivery_names_0")
    private WebElement incomingDeliveryName;  // Numer dokumentu

    public String getPageUrl() {
        return pageUrl;
    }

    public WebElement getAddDeliveryPanelHead() {
        return addDeliveryPanelHead;
    }

    public AddNewDeliveryPage fillIncomingDeliveryName(String name) {
        incomingDeliveryName.sendKeys(name);
        return this;
    }

}
