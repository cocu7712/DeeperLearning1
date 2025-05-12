package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);

        while (true){
            log("프린터할 문서를 일렵하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if (input.equals("q")){
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }


    }

    static class Printer implements Runnable{

        /* volatile 여러 Thread가 접근 하는 변수에 붙여야 안전 */
        volatile boolean work = true;

        /* 여러 Thread가 동시에 접근하는 경우 컬렉션 프레임워크가 제공하는 일반적인 자료구조를 사용하면 안전하지 않음으로 여러 스레드가 접근하는
           경우 동시성 지원하는 동시성 컬렉션을 사용해야 한다. Queue 는 ConcurrentLinkedQueue 사용하면 됨
        */
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (work){
                if (jobQueue.isEmpty()){
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }

            log("프린터 종료");
        }

        public void addJob (String input){
            jobQueue.offer(input);
        }
    }



}


