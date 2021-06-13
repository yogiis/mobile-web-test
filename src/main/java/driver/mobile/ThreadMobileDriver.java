package driver.mobile;

import io.appium.java_client.android.AndroidDriver;

public class ThreadMobileDriver {
    private static ThreadLocal<AndroidDriver<?>> tlDriver = new ThreadLocal<>();

    public static void setTlDriver(AndroidDriver<?> driver) {
        tlDriver.set(driver);
    }

    public static AndroidDriver<?> getTldriver(){
        return tlDriver.get();
    }
}
