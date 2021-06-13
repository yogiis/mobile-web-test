package pages.mobile;

import driver.mobile.ThreadMobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import utils.WaitUtils;

import java.io.*;

public class RegisterScreen extends BaseMobilePage {
    private static WaitUtils wait = new WaitUtils();
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textViewLinkRegister\"))")
    MobileElement createOne;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"android:id/autofill_dataset_picker\"))")
    MobileElement autoFillPicker;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextName\"))")
    MobileElement fieldTextName;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextEmail\"))")
    MobileElement fieldTextEmail;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextPassword\"))")
    MobileElement fieldTextPassword;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/textInputEditTextConfirmPassword\"))")
    MobileElement fieldTextConfirmPassword;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/appCompatButtonRegister\"))")
    MobileElement buttonRegister;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/appCompatTextViewLoginLink\"))")
    MobileElement memberLogin;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Enter Valid Email')]")
    AndroidElement textValidEmailEnter;

    public RegisterScreen(ThreadMobileDriver driver) {
        super(driver);
    }

    public void clickMemberLogin() throws InterruptedException {
        wait.staticWait(1000);
        memberLogin.click();
    }

    public void viewScreenLogin() {
        try {
            boolean autoFillPickerDisplayed = autoFillPicker.isDisplayed();
            if (autoFillPickerDisplayed) {
                ThreadMobileDriver.getTldriver().navigate().back();
            } else {
                boolean loginScreenDisplayed = createOne.isDisplayed();
                Assert.assertTrue(loginScreenDisplayed);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickTextLinkCreateOne() throws InterruptedException {
        wait.staticWait(500);
        createOne.click();
    }

    public void viewScreenRegister() {
        boolean registerScreenDisplay = memberLogin.isDisplayed();
        Assert.assertTrue(registerScreenDisplay);
    }

    public void fillTextName(String name) throws InterruptedException {
        wait.staticWait(500);
        fieldTextName.clear();
        fieldTextName.sendKeys(name);
    }

    public void fillTextEmail(String email) throws InterruptedException {
        wait.staticWait(500);
        fieldTextEmail.clear();
        fieldTextEmail.sendKeys(email);
    }

    public void fillTextPassword(String password) throws InterruptedException {
        wait.staticWait(500);
        fieldTextPassword.clear();
        fieldTextPassword.sendKeys(password);
    }

    public void fillTextConfirmPassword(String confirmPassword) throws InterruptedException {
        wait.staticWait(500);
        fieldTextConfirmPassword.clear();
        fieldTextConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickButtonRegister() throws InterruptedException {
        wait.staticWait(500);
        buttonRegister.click();
    }

    public void verifyMessageError() throws InterruptedException {
        wait.staticWait(500);
        boolean textValidEmailEnterDisplayed = textValidEmailEnter.isDisplayed();
        Assert.assertTrue(textValidEmailEnterDisplayed);
    }

    public void collectDataAccount(String name, String email, String password) throws IOException {
        String prefix = "/Users/mac/Project/BukalapakTest/";
        String filePath = "mobile-web-test-bukalapak/src/main/java/export/useraccountregister.csv";
        String fullPath = prefix.concat(filePath);

        File file = new File(fullPath);

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name);
        stringBuilder.append(",");
        stringBuilder.append(email);
        stringBuilder.append(",");
        stringBuilder.append(password);
        stringBuilder.append("\r\n");

        printWriter.write(stringBuilder.toString());
        printWriter.close();
    }

}
