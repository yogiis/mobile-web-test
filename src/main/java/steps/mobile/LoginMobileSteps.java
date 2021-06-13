package steps.mobile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.mobile.ThreadMobileDriver;
import helper.Context;
import helper.ScenarioContext;
import pages.mobile.LoginScreen;

public class LoginMobileSteps {

    public ThreadMobileDriver driver;
    ScenarioContext scenarioContext;
    RegisterMobileSteps registerMobileSteps;
    private LoginScreen loginScreen;

    public LoginMobileSteps(RegisterMobileSteps registerSteps, ScenarioContext context) {
        this.registerMobileSteps = registerSteps;
        driver = registerSteps.driver;
        this.scenarioContext = context;
    }

    @When("^user input email correct$")
    public void userInputEmailCorrect() throws Throwable {
        String setEmail = (String) scenarioContext.getCotext(Context.EMAIL);
        loginScreen = new LoginScreen(driver);
        loginScreen.fillInputEmail(setEmail);
    }

    @And("^user input password correct$")
    public void userInputPasswordCorrect() throws Throwable {
        String setPassword = (String) scenarioContext.getCotext(Context.PASSWORD);
        loginScreen = new LoginScreen(driver);
        loginScreen.fillInputPassword(setPassword);
    }

    @Then("^user success on screen dashboard$")
    public void userSuccessOnScreenDashboard() throws InterruptedException {
        loginScreen = new LoginScreen(driver);
        loginScreen.viewScreenDashboard();
    }

    @And("^user click button login$")
    public void userClickButtonLogin() throws InterruptedException {
        loginScreen = new LoginScreen(driver);
        loginScreen.clickButtonLogin();
    }
}
