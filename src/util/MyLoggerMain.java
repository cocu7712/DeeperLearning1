package util;

import thread.start.HelloThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLoggerMain {

    public static void main(String[] args) {
        MyLogger.log("hello thread");
        MyLogger.log(123);

    }
}
