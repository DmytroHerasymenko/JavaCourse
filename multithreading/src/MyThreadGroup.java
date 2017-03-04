/**
 * Created by dima on 04.03.17.
 */

class MyThread4 implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("mythread");
        }
    }
}

public class MyThreadGroup {
    public static void main(String[] args) {
        ThreadGroup parentThreadGroup = new ThreadGroup("parent");
        ThreadGroup threadGroup = new ThreadGroup(parentThreadGroup,"adsf");

        MyThread4 myThread = new MyThread4();
        Thread thread = new Thread(threadGroup, myThread);
        thread.setPriority(7);
        thread.start();
    }
}
