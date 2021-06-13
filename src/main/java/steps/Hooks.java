package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.mobile.ThreadMobileDriver;

public class Hooks extends BaseSteps {

    @Before
    public void setup() {
        if (ThreadMobileDriver.getTldriver() != null) {
            setupCucumberMobile();
        } else {
            System.out.println("Setup Switch Web Test");
            setupCucumberWeb();
        }
    }

    @After
    public void stop(Scenario scenario) {
        if (ThreadMobileDriver.getTldriver() != null) {
            tearDownMobile(scenario);
        } else {
            System.out.println("Setup Switch Web Test");
            tearDownWeb(scenario);
        }
    }
}
