package problems;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class example1_3 {

    /* 문제 4 - 멅티 스레드 
    * 1. 2개의 스레드 만들기
    * 2. A 스레드 = 1초 마다, B 스레드 = 0.5초 마다
    * 3. 강제 종료시 까지
    */

    public static void main(String[] args) {
        /* Thread Create */
        new Thread(new roopRunnableA(), "Thread-A").start();
        new Thread(new roopRunnableB(), "Thread-B").start();
    }

    static class roopRunnableA implements Runnable{
        @Override
        public void run() {
            int i = 1;
            while (true){
                try {
                    sleep(1000);
                    log("value : " + i++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class roopRunnableB implements Runnable{
        @Override
        public void run() {
            int i = 1;
            while (true){
                try {
                    sleep(500);
                    log("value : " + i++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
