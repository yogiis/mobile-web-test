package driver.web;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseWebTest extends DesiredCapabilities {

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void preparation(String browser) throws Exception {
        if (browser.equals("chrome")) {
            DesiredCapabilities capability = chrome();
            capability.setCapability("browserName", "chrome");
            capability.setCapability("platform", "MAC");
            ChromeOptions options = new ChromeOptions();
            options.merge(capability);
            ThreadWebDriver.setTLDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
        } else if (browser.equals("firefox")) {
            DesiredCapabilities capability = firefox();
            capability.setCapability("browserName", "firefox");
            capability.setCapability("platform", "MAC");
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capability);
            ThreadWebDriver.setTLDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
        }

        ThreadWebDriver.getTLDriver().manage().window().maximize();
        ThreadWebDriver.getTLDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void stopServer() {
        ThreadWebDriver.getTLDriver().quit();
    }
}
