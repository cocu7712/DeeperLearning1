package thread.control;

import thread.start.HelloThread;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {

        /* Main Thread */

        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId = " + mainThread.threadId());             /* 중복 불가능 */
        log("mainThread.getName = " + mainThread.getName());               /* 중복 가능 */
        log("mainThread.getPriority = " + mainThread.getPriority());       /* 우선 순위 (높다고 무조건 우선은 아님) */
        log("mainThread.getThreadGroup = " + mainThread.getThreadGroup()); /*  */
        log("mainThread.getState = " + mainThread.getState())              /* 상태 (Runnable = 실행중) */;

        System.out.println(" =========== [My Thread] ================= ");

        /* Make */
        Thread myThread = new Thread(new HelloThread(),"MyThread");
        log("myThread = " + myThread);
        log("myThread.threadId = " + myThread.threadId());             /* 중복 불가능 */
        log("myThread.getName = " + myThread.getName());               /* 중복 가능 */
        log("myThread.getPriority = " + myThread.getPriority());       /* 우선 순위 (높다고 무조건 우선은 아님) */
        log("myThread.getThreadGroup = " + myThread.getThreadGroup()); /* id, name, priority, group */
        log("myThread.getState = " + myThread.getState())              /* 상태 (New = 아직 실행 안됨) */;

    }
}
