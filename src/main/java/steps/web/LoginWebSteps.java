package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.web.ThreadWebDriver;
import pages.web.LoginPage;

public class LoginWebSteps {
    public LoginPage loginPage;
    public ThreadWebDriver webDriver;
    RegisterWebSteps registerWebSteps;

    public LoginWebSteps(RegisterWebSteps registerWebSteps) {
        this.registerWebSteps = registerWebSteps;
        webDriver = registerWebSteps.webDriver;
    }

    @When("^user click button login from register page Bukalapak$")
    public void userClickButtonLoginFromRegisterPageBukalapak() {
        loginPage = new LoginPage(webDriver);
        loginPage.clickButtonLogOnReg();
    }

    @And("^user fill username Bukalapak \"([^\"]*)\"$")
    public void userFillUsernameBukalapak(String username) throws Throwable {
        loginPage = new LoginPage(webDriver);
        loginPage.fillUsername(username);
    }

    @And("^user fill password Bukalapak \"([^\"]*)\"$")
    public void userFillPasswordBukalapak(String password) throws Throwable {
        loginPage = new LoginPage(webDriver);
        loginPage.fillPassword(password);
    }

    @Then("^user click button login Bukalapak$")
    public void userClickButtonLoginBukalapak() {
        loginPage = new LoginPage(webDriver);
        loginPage.clickButtonLogin();
    }

}
