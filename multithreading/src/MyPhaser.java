import java.util.concurrent.Phaser;

/**
 * Created by dima on 15.03.17.
 */

class MyThread7 extends Thread{
    Phaser phaser;

    public MyThread7(Phaser phaser){
        this.phaser = phaser;
    }

    public void run(){
        phaser.register();
        System.out.println("thread is registered");
    }
}

class MyThread8 extends Thread{
    Phaser phaser;

    public MyThread8(Phaser phaser){
        this.phaser = phaser;
    }

    public void run(){
        phaser.arriveAndAwaitAdvance();
        System.out.println("the thread is deregistered");
    }
}

class MyThread9 extends Thread{
    Phaser phaser;

    public MyThread9(Phaser phaser){
        this.phaser = phaser;
    }

    public void run(){
        phaser.arrive();
        System.out.println("the thread is arrived");
    }

}

public class MyPhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        MyThread7 myThread = new MyThread7(phaser);
        MyThread8 myThread1 = new MyThread8(phaser);
        MyThread8 myThread2 = new MyThread8(phaser);
        MyThread8 myThread3 = new MyThread8(phaser);
        //MyThread8 myThread4 = new MyThread8(phaser);

        MyThread9 myThread5 = new MyThread9(phaser);

        myThread.start();
        myThread1.start();
        myThread2.start();
        //myThread3.start();
        //myThread4.start();
        myThread5.start();
    }
}
