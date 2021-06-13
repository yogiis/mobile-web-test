package pages.mobile;

import driver.mobile.ThreadMobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import utils.WaitUtils;

public class LoginScreen extends BaseMobilePage {
    private static WaitUtils wait = new WaitUtils();
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextEmail\"))")
    MobileElement fieldInputEmail;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextPassword\"))")
    MobileElement fieldInputPassword;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/appCompatButtonLogin\"))")
    MobileElement buttonLogin;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Android NewLine Learning')]")
    AndroidElement textDashboard;
    public LoginScreen(ThreadMobileDriver driver) {
        super(driver);
    }

    public void fillInputEmail(String email) throws InterruptedException {
        wait.staticWait(500);
        fieldInputEmail.sendKeys(email);
    }

    public void fillInputPassword(String password) throws InterruptedException {
        wait.staticWait(500);
        fieldInputPassword.sendKeys(password);
    }

    public void clickButtonLogin() throws InterruptedException {
        wait.staticWait(500);
        buttonLogin.click();
    }

    public void viewScreenDashboard() throws InterruptedException {
        wait.staticWait(1000);
        boolean loginScreenDisplayed = textDashboard.isDisplayed();
        Assert.assertTrue(loginScreenDisplayed);
    }

}
