/**
 * Created by dima on 01.03.17.
 */

class MyThread extends Thread {
    Object objectA;
    Object objectB;

    public MyThread(Object objectA, Object objectB) {
        this.objectA = objectA;
        this.objectB = objectB;
    }

    public void run(){
        synchronized (objectA){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectB){

            }
        }
    }
}

public class Deadlock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        MyThread myThread1 = new MyThread(object1, object2);
        MyThread myThread2 = new MyThread(object2, object1);
        myThread1.start();
        myThread2.start();
    }
}
