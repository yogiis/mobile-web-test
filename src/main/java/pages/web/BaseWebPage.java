package pages.web;

import driver.web.ThreadWebDriver;
import utils.WaitUtils;

public class BaseWebPage {
    protected final ThreadWebDriver webDriver;
    WaitUtils waitUtils;

    protected BaseWebPage(ThreadWebDriver webDriver){
        this.webDriver = webDriver;
        waitUtils = new WaitUtils();
    }
}
