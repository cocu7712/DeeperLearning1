package thread.start;

import static util.MyLogger.log;

public class ManyThreadMain {

    public static void main(String[] args) {

        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

//        Thread thread1 = new Thread(runnable);
//        thread1.start();
//        Thread thread2 = new Thread(runnable);
//        thread2.start();
//        Thread thread3 = new Thread(runnable);
//        thread3.start();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        log("main() end");

    }


}
