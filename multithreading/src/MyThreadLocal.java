/**
 * Created by dima on 04.03.17.
 */

class MyThread3 extends Thread{
    ThreadLocal<Integer> threadLocal;
    int value;

    public MyThread3(ThreadLocal<Integer> threadLocal, int value){
        this.threadLocal = threadLocal;
        this.value = value;
    }

    public void run(){
        this.threadLocal.set(value);
        System.out.println(threadLocal.get());
    }
}

public class MyThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        MyThread3 myThread1 = new MyThread3(threadLocal, 100);
        MyThread3 myThread2 = new MyThread3(threadLocal, 200);
        myThread1.start();
        myThread2.start();

    }
}
