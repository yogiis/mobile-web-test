package driver.mobile;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseMobileTest {

    private final static String packageName = "com.loginmodule.learning";
    private final static String activity = "com.loginmodule.learning.activities.LoginActivity";
    private final static String uiautomator = "UiAutomator2";

    protected static AppiumDriverLocalService service;

    @BeforeSuite
    public void preparation() {
        System.out.println("Started Testing");
    }

    @BeforeTest
    @Parameters({"udid", "platformVersion"})
    public void start(String udid, String platformVersion) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", packageName);
        capabilities.setCapability("appActivity", activity);
        capabilities.setCapability("clearSystemFile", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", uiautomator);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("newCommandTimeout", 10000);

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        String service_url = service.getUrl().toString();
        System.out.println("Appium Service Address: " + service_url);
        ThreadMobileDriver.setTlDriver(new AndroidDriver<WebElement>(new URL(service_url), capabilities));
    }

    @AfterTest
    public void stopDriver() {
        try {
            if (ThreadMobileDriver.getTldriver() != null) {
                ThreadMobileDriver.getTldriver().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void stopService() {
        service.stop();
    }


}
