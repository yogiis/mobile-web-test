package pages.web;

import driver.web.ThreadWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseWebPage {
    public LoginPage(ThreadWebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonLogOnReg() {
        WebElement loginButtonOnReg = ThreadWebDriver.getTLDriver().findElement(By.cssSelector(".bl-link"));
        loginButtonOnReg.click();
    }

    public void fillUsername(String username) {
        WebElement fieldUsername = ThreadWebDriver.getTLDriver().findElement(By.id("user_session_username"));
        fieldUsername.sendKeys(username);
    }

    public void fillPassword(String password) {
        WebElement fieldPassword = ThreadWebDriver.getTLDriver().findElement(By.id("user_session_password"));
        fieldPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        WebElement buttonLogin = ThreadWebDriver.getTLDriver().findElement(By.name("commit"));
        buttonLogin.click();
    }

}
