package pages;

import bc.artest.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryViewPage {

    private final String pageURL = Configuration.get("baseURL") + "/delivery";

    public DeliveryViewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-wrapper']//a[contains(text(), 'Wyloguj')]")
    private WebElement logOutButon;

    @FindBy(xpath = "//div[@id='page-wrapper']//h3[text()=' Przeglądaj dostawy ']")
    private WebElement filterDeliveryPanelHeading;

    @FindBy(name = "deliveryId")
    private WebElement deliveryIdInput;

    @FindBy(name = "submitFilters")
    private WebElement submitFiltersButton;

    @FindBy(id = "filterTable")
    private WebElement deliveryList;

    public String getPageURL() {
        return pageURL;
    }

    public WebElement getLogOutButon() {
        return logOutButon;
    }

    public WebElement getFilterDeliveryPanelHeading() {
        return filterDeliveryPanelHeading;
    }

    public WebElement getDeliveryIdInput() {
        return deliveryIdInput;
    }

    public WebElement getSubmitFiltersButton() {
        return submitFiltersButton;
    }

    public WebElement getDeliveryList() {
        return deliveryList;
    }

}
