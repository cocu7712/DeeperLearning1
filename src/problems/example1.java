package problems;

import static java.lang.Thread.sleep;
import static util.MyLogger.log;

public class example1 {

    /* 문제 1: Thread 상속
    * 1. Thread 클래스를 상속받은 CounterThread라는 스레드를 만들자.
    * 2. 이 스레드는 1 ~ 5 까지 숫자를 1초 간격으로 출력해야 한다. log() 기능 사용 출력할 것
    * 3. main() 메서드에서 CounterThread 스레드 클래스를 만들고 실행해라
    * 4. 실행 결과를 참고하자
    *  */

    public static void main(String[] args) {

        /* 1 */
//        CounterThread counterThread = new CounterThread();
//        counterThread.start();

        /* 2 */

        Thread thread = new Thread(new CounterRunnable(), "counter");
        thread.start();
    }

    static class CounterThread extends Thread{

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
