package utils;

import java.util.concurrent.TimeUnit;

public class WaitUtils {

    public void staticWait(final long millis) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(millis);
    }
}
