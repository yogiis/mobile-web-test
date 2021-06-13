package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import driver.web.BaseWebTest;
import org.testng.annotations.*;


@CucumberOptions(
        features = "classpath:features/01_register_login_search_addtocart_web.feature",
        glue = {"steps"},
        tags = {"@test"},
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber-report/web-firefox-bukalapak-test.json"}
)
public class FirefoxRunner extends BaseWebTest {

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

    @DataProvider(parallel = true)
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println("Final Session TestNG for Cucumber");
        testNGCucumberRunner.finish();
    }
}
