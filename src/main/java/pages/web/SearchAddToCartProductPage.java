package pages.web;

import driver.web.ThreadWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAddToCartProductPage extends BaseWebPage {
    WebDriverWait webDriverWait = new WebDriverWait(ThreadWebDriver.getTLDriver(), 10);
    By productName = By.xpath("//div[@class='bl-flex-container flex-wrap is-gutter-16']/div[1]");
    By iconSearch = By.cssSelector(".v-omnisearch__submit-icon");
    public SearchAddToCartProductPage(ThreadWebDriver webDriver) {
        super(webDriver);
    }

    public void fillProductName(String productName) {
        WebElement fieldSearch = ThreadWebDriver.getTLDriver().findElement(By.id("v-omnisearch__input"));
        fieldSearch.sendKeys(productName);
    }

    public void clickIconSearch() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(iconSearch)).click();
    }

    public void clickItemProductName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productName)).click();
    }

    public void addProductToCart() {
        WebElement buttonCart = ThreadWebDriver.getTLDriver().findElement(By.cssSelector(".c-main-product__action__cart"));
        Actions actions = new Actions(ThreadWebDriver.getTLDriver());
        actions.moveToElement(buttonCart);
        actions.perform();
        buttonCart.click();
    }

}
