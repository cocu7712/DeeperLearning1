package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " :: main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " :: start 호출 전");
        
        /* run() 이 아닌 반드시 start() 메서드를 호출 할 것 :: 그래야 별도의 스레드에서 run() 코드가 실행됨 */
        helloThread.start();

        System.out.println(Thread.currentThread().getName() + " :: start 호출 후");

        System.out.println(Thread.currentThread().getName() + " :: main() end");

    }
}
