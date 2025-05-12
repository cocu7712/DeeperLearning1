package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws Exception{
        log("Start");
        /* Runnable 생성 */
        SumTask sumTask1 = new SumTask(1, 50);

        /* Thread 생성 */
        Thread thread = new Thread(sumTask1, "Thread-1");

        /* Thread 실행 */
        thread.start();

        /* 스레드가 종료될 떄 까지 대기 */
        log("join() - main 스레드가 thread1 종료까지 1초 대기");
        thread.join(1000);
        log("main 스레드 대기 완료");

        log("task1.result = " + sumTask1.result);
        log("End");
    }

    static class SumTask implements Runnable{

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startvalue, int endValue){
            this.startValue = startvalue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i < endValue; i++) {
                 sum += i;
            }

            result = sum;
            log("작업 완료 result = " + result);
        }

    }
}

