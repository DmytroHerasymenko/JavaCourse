/**
 * Created by dima on 04.03.17.
 */
class MyHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.getMessage());
    }
}

class MyThread2 extends Thread {
    public void run(){
        if(true){
            throw new RuntimeException("my thread throw exception");
        }
    }
}

public class MyExceptionHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyHandler());
        MyThread2 myThread = new MyThread2();
        myThread.start();
    }
}
