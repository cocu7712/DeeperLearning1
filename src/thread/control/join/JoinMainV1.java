package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {

    public static void main(String[] args) throws Exception{
        log("Start");
        /* Runnable 생성 */
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(50, 100);

        /* Thread 생성 */
        Thread thread = new Thread(sumTask1, "Thread-1");
        Thread thread2 = new Thread(sumTask2, "Thread-2");

        /* Thread 실행 */
        thread.start();
        thread2.start();

        /* 각 실행 thread 결과 값 log */
        log("task1.result = " + sumTask1.result);
        log("task2.result = " + sumTask2.result);

        int sumAll = sumTask1.result + sumTask2.result;
        log("sumAll.result = " + sumAll);

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

