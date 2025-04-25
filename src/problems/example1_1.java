package problems;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class example1_1 {

    /* 문제 2 - Runnable 상속 */

    public static void main(String[] args) {

        Thread thread = new Thread(new CounterRunnable(), "counter");
        thread.start();
    }

    static class CounterRunnable implements Runnable {
        @Override
        public void run(){
            for (int i = 1; i <= 5; i++) {
                try {
                    sleep(1000);
                    log("value : " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}
