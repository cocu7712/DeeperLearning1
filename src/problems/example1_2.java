package problems;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class example1_2 {

    /* 문제 3 - 익명 Runnable */

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        sleep(1000);
                        log("value : " + i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "counter").start();
    }

}
