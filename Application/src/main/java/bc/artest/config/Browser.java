package bc.artest.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Browser {

    private static String os = OS.checkOS();
    private static String pathToDriver = "../Drivers/";
    private static Map<String, String[]> browsers;
    static {
        browsers = new HashMap<>();
        String[] chromeArray = {"google", "chrome"};
        browsers.put("Google Chrome", chromeArray);
        String[] ffArray = {"ff", "firefox", "mozilla"};
        browsers.put("Mozilla Firefox", ffArray);
        String[] phantomArray = {"phantom", "phantomjs"};
        browsers.put("PhnatomJS", phantomArray);
    }

    /**
     * Set global browser configuration.
     * @param driver - for initialization.
     * @return - initialized driver.
     * @throws IOException - trouble with properties file from Configuration class.
     */
    public static WebDriver setBrowserConfig(WebDriver driver, String path) throws IOException {
        System.out.println("Running method setBrowserConfig");
        pathToDriver = path;
        Configuration.load();
        String browserName = Configuration.get("browser").toLowerCase();
        if (browserName.equals("firefox") || browserName.equals("ff")) {
            setFirefox();
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            setChrome();
            driver = new ChromeDriver();
        } else if (browserName.equals("phantomjs") || browserName.equals("phantom")) {
            driver = new PhantomJSDriver(setPhantomJS());
        }
        return driver;
    }

    /**
     * Set driver configuration for Mozilla Firefox browser.
     */
    private static void setFirefox() {
        if (os.equals("win")) {
            System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver.exe");
        } else if (os.equals("mac")) {
            System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver");
        }
    }

    /**
     * Set driver configuration for Google Chrome browser.
     */
    private static void setChrome() {
        if (os.equals("win")) {
            System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
        } else if (os.equals("mac")) {
            System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");
        }
    }

    /**
     * Set capabilities for PhantomJS browser.
     * @return - capabilities.
     */
    private static DesiredCapabilities setPhantomJS() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                pathToDriver + "phantomjs.exe");
        return capabilities;
    }

    public static String getBrowserName() {
        for (Map.Entry<String, String[]> entry : browsers.entrySet()) {
            for (String text : entry.getValue()) {
                if (Configuration.get("browser").equals(text)) {
                    return entry.getKey();
                }
            }
        }
        return "Unkown Browser";
    }

    // TODO: Add more browsers (Edge, IE)
    // TODO: Add more drivers for others OS (Unix, Mac)
}
