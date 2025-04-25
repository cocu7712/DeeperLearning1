package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV4 {

    /*
    * Thread 생성 및 사용 할 경우에는 Runnable을 사용해야 한다.
    * 이유 : 자바는 단일 상속이여서  이미 다른 클래스를 상속 받는경우 Thread를 받을 수 없어 유연성이 떨어짐
    */

    public static void main(String[] args) {

        log("main() start");

        Thread thread = new Thread(() -> log(Thread.currentThread().getName() + " :: name"));
        thread.start();

        log("main() end");
    }


}
