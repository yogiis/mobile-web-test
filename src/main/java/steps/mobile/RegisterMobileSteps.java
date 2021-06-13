package steps.mobile;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.mobile.ThreadMobileDriver;
import helper.Context;
import helper.ScenarioContext;
import pages.mobile.RegisterScreen;
import steps.Hooks;

import java.util.Locale;

public class RegisterMobileSteps {

    public ThreadMobileDriver driver;
    ScenarioContext scenarioContext;
    Hooks hooks;
    Faker faker = new Faker(new Locale("in-ID"));
    String setName = "test-" + faker.name().fullName();
    String setEmail = faker.name().username() + "@testing.com";
    String setPassword = faker.phoneNumber().subscriberNumber(5);
    String setUsername = faker.name().username();
    private RegisterScreen registerScreen;

    public RegisterMobileSteps(Hooks hooks, ScenarioContext context) {
        this.hooks = hooks;
        driver = hooks.driver;
        this.scenarioContext = context;
    }

    @Given("^user on screen login$")
    public void userOnScreenLogin() {
        registerScreen = new RegisterScreen(driver);
        registerScreen.viewScreenLogin();
    }

    @When("^user click Create one$")
    public void userClickCreateOne() throws InterruptedException {
        registerScreen = new RegisterScreen(driver);
        registerScreen.clickTextLinkCreateOne();
    }

    @Then("^user success on screen register$")
    public void userSuccessOnScreenRegister() {
        registerScreen = new RegisterScreen(driver);
        registerScreen.viewScreenRegister();
    }

    @When("^user fill full name$")
    public void userFillFullName() throws Throwable {
        registerScreen = new RegisterScreen(driver);
        registerScreen.fillTextName(setName);
        scenarioContext.setContext(Context.NAME, setName);
    }

    @And("^user fill email$")
    public void userFillEmail() throws Throwable {
        registerScreen = new RegisterScreen(driver);
        registerScreen.fillTextEmail(setEmail);
        scenarioContext.setContext(Context.EMAIL, setEmail);
    }

    @And("^user fill password$")
    public void userFillPassword() throws Throwable {
        registerScreen = new RegisterScreen(driver);
        registerScreen.fillTextPassword(setPassword);
        scenarioContext.setContext(Context.PASSWORD, setPassword);
    }

    @And("^user fill confirm password$")
    public void userFillConfirmPassword() throws Throwable {
        String setConfirmPassword = (String) scenarioContext.getCotext(Context.PASSWORD);
        registerScreen = new RegisterScreen(driver);
        registerScreen.fillTextConfirmPassword(setConfirmPassword);
    }


    @Then("^user click button register$")
    public void userClickButtonRegister() throws InterruptedException {
        registerScreen = new RegisterScreen(driver);
        registerScreen.clickButtonRegister();
    }

    @And("^collect data account after registeter$")
    public void collectDataAccountAfterRegisteter() throws Throwable {
        String setName = (String) scenarioContext.getCotext(Context.NAME);
        String setEmail = (String) scenarioContext.getCotext(Context.EMAIL);
        String setPassword = (String) scenarioContext.getCotext(Context.PASSWORD);
        registerScreen = new RegisterScreen(driver);
        registerScreen.collectDataAccount(setName, setEmail, setPassword);
    }

    @And("^user click member Login$")
    public void userClickMemberLogin() throws InterruptedException {
        registerScreen = new RegisterScreen(driver);
        registerScreen.clickMemberLogin();
    }

    @And("^user fill username$")
    public void userFillUsername() throws Throwable {
        registerScreen = new RegisterScreen(driver);
        registerScreen.fillTextEmail(setUsername);
    }

    @And("^user verify message error$")
    public void userVerifyMessageError() throws InterruptedException {
        registerScreen = new RegisterScreen(driver);
        registerScreen.verifyMessageError();
    }
}
