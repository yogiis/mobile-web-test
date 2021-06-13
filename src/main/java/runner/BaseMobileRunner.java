package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import driver.mobile.BaseMobileTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"classpath:features/00_register_login_android.feature"},
        glue = {"steps"},
        tags = {"@test"},
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber-report/mobile-bukalapak-test.json"})
public class BaseMobileRunner extends BaseMobileTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Setup TestNG for Cucumber");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("In Test TestNG for Cucumber");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider()
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println("Final Session TestNG for Cucumber");
        testNGCucumberRunner.finish();
    }
}
