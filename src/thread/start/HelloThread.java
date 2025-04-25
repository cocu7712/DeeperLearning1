package thread.start;

public class HelloThread extends Thread {

    /*
     * Thread 클래스 상속 & 실행 코드 run 재 정의
     * Thread.currentThread() :: 해당 코드의 스레드 객체 조회
     * Thread.currentThread().getName() :: 실행 중인 스레드의 이름 조회
     */ 
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + ":: run() ");
    }

}
