package steps.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.web.ThreadWebDriver;
import pages.web.SearchAddToCartProductPage;

public class SearchAddToCartProductSteps {

    public SearchAddToCartProductPage searchAddToCartProductPage;
    public ThreadWebDriver webDriver;
    LoginWebSteps loginWebSteps;

    public SearchAddToCartProductSteps(LoginWebSteps loginWebSteps) {
        this.loginWebSteps = loginWebSteps;
        webDriver = loginWebSteps.webDriver;
    }

    @When("^user fill product name on field search \"([^\"]*)\"$")
    public void userFillProductNameOnFieldSearch(String productName) throws Throwable {
        searchAddToCartProductPage = new SearchAddToCartProductPage(webDriver);
        searchAddToCartProductPage.fillProductName(productName);
    }

    @And("^user click icon search$")
    public void userClickIconSearch() {
        searchAddToCartProductPage = new SearchAddToCartProductPage(webDriver);
        searchAddToCartProductPage.clickIconSearch();
    }

    @And("^user click item product$")
    public void userClickItemProduct() {
        searchAddToCartProductPage = new SearchAddToCartProductPage(webDriver);
        searchAddToCartProductPage.clickItemProductName();
    }

    @Then("^user add product to cart$")
    public void userAddProductToCart() {
        searchAddToCartProductPage = new SearchAddToCartProductPage(webDriver);
        searchAddToCartProductPage.addProductToCart();
    }
}
