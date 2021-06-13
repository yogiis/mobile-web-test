package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.web.ThreadWebDriver;
import pages.web.RegisterWebPage;
import steps.Hooks;

public class RegisterWebSteps {
    public RegisterWebPage registerWebPage;
    public ThreadWebDriver webDriver;
    Hooks hooks;

    public RegisterWebSteps(Hooks hooks) {
        this.hooks = hooks;
        webDriver = hooks.webDriver;
    }

    @Given("^user opens the Bukalapak URL in browser$")
    public void userOpensTheBukalapakURLInBrowser() {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.openBrowserBukalapak();
    }

    @When("^user click button daftar on home page Bukalapak$")
    public void userClickButtonDaftarOnHomePageBukalapak() {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.clickButtonDaftarHome();
    }

    @And("^user input phone number \"([^\"]*)\"$")
    public void userInputPhoneNumber(String phoneNumber) throws Throwable {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.fillPhoneNumber(phoneNumber);
    }

    @And("^user click button daftar$")
    public void userClickButtonDaftar() {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.clickButtonDaftar();
    }

    @And("^user click button ya kirim kode$")
    public void userClickButtonYaKirimKode() {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.clickButtonSubmit();
    }

    @Then("^user click icon close$")
    public void userClickIconClose() {
        registerWebPage = new RegisterWebPage(webDriver);
        registerWebPage.clickIconClose();
    }
}
