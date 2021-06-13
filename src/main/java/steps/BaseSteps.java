package steps;

import cucumber.api.Scenario;
import driver.mobile.ThreadMobileDriver;
import driver.web.ThreadWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class BaseSteps {

    public ThreadMobileDriver driver;
    public ThreadWebDriver webDriver;
    protected WebDriverWait wait;

    protected void setupCucumberMobile() {
        System.out.println("Cucumber Base Step");
        wait = new WebDriverWait(ThreadMobileDriver.getTldriver(), 20);

    }

    protected void setupCucumberWeb() {
        System.out.println("Cucumber Base Step");
        wait = new WebDriverWait(ThreadWebDriver.getTLDriver(), 10);
    }

    protected void tearDownMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                if (ThreadMobileDriver.getTldriver() != null)
                    ThreadMobileDriver.getTldriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Objects.requireNonNull(ThreadMobileDriver.getTldriver()).getSessionId();
    }

    protected void tearDownWeb(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                if (ThreadWebDriver.getTLDriver() != null)
                    ThreadWebDriver.getTLDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Objects.requireNonNull(ThreadWebDriver.getTLDriver()).getSessionId();
    }
}
