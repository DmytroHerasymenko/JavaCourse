/**
 * Created by dima on 04.03.17.
 */

class MyThread1 extends Thread {
    public void run(){
        while(!interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        }
        System.out.println("sdf");
    }
}

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread = new MyThread1();
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();

    }
}
