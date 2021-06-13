package pages.web;

import driver.web.ThreadWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterWebPage extends BaseWebPage {
    WebDriverWait webDriverWait = new WebDriverWait(ThreadWebDriver.getTLDriver(), 10);
    By buttonDaftarHome = By.xpath("//a[.='Daftar']");

    public RegisterWebPage(ThreadWebDriver webDriver) {
        super(webDriver);
    }

    public void openBrowserBukalapak() {
        ThreadWebDriver.getTLDriver().manage().window().maximize();
        ThreadWebDriver.getTLDriver().get("https://www.bukalapak.com/");
    }

    public void clickButtonDaftarHome() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonDaftarHome)).click();
    }

    public void fillPhoneNumber(String phoneNumber) {
        WebElement fieldPhoneNumber = ThreadWebDriver.getTLDriver().findElement(By.cssSelector("[placeholder]"));
        fieldPhoneNumber.sendKeys(phoneNumber);
    }

    public void clickButtonDaftar() {
        WebElement buttonDaftar = ThreadWebDriver.getTLDriver().findElement(By.cssSelector(".bl-button--primary"));
        buttonDaftar.click();
    }

    public void clickButtonSubmit() {
        WebElement buttonSubmit = ThreadWebDriver.getTLDriver().findElement(By.cssSelector(".mb-8"));
        buttonSubmit.click();
    }

    public void clickIconClose() {
        WebElement buttonSubmit = ThreadWebDriver.getTLDriver().findElement(By.cssSelector(".ml-16"));
        buttonSubmit.click();
    }
}
