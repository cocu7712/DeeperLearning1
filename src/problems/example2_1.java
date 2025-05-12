package problems;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class example2_1 {

    /*
      문제 2: Thread 9초 -> 3초 걸리게 변경
    */

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("모든 스레드 실행 완료");

    }

    static class MyTask implements Runnable {
        @Override
        public void run(){
            for (int i = 0; i < 3; i++) {
                 log(i);
                 sleep(1000);
            }
        }
    }

}
