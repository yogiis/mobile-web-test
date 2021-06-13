package pages.mobile;

import driver.mobile.ThreadMobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.time.Duration;

public class BaseMobilePage {

    protected final ThreadMobileDriver driver;
    WaitUtils waitUtils;


    protected BaseMobilePage(ThreadMobileDriver driver) {
        this.driver = driver;
        initElements();
        waitUtils = new WaitUtils();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(ThreadMobileDriver.getTldriver(), Duration.ofSeconds(10)), this);
    }

}
