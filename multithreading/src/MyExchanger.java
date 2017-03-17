import java.util.concurrent.Exchanger;

/**
 * Created by dima on 15.03.17.
 */
class MyThread10 extends Thread{
    Exchanger<Integer> exchanger;
    Integer i;

    public MyThread10(Exchanger<Integer> exchanger, Integer i){
        this.exchanger = exchanger;
        this.i = i;
    }

    public void run(){
        try {
            Integer i1 = exchanger.exchange(i);
            System.out.println(i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MyExchanger {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        MyThread10 myThread1 = new MyThread10(exchanger, 10);
        MyThread10 myThread2 = new MyThread10(exchanger, 20);
        myThread1.start();
        myThread2.start();
    }
}
