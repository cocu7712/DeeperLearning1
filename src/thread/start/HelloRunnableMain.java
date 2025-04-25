package thread.start;

public class HelloRunnableMain {

    /*
    * Thread 생성 및 사용 할 경우에는 Runnable을 사용해야 한다.
    * 이유 : 자바는 단일 상속이여서  이미 다른 클래스를 상속 받는경우 Thread를 받을 수 없어 유연성이 떨어짐
    */

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " :: main() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);

        thread.start();

        System.out.println(Thread.currentThread().getName() + " :: main() end");

    }
}
