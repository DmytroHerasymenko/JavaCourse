import java.util.concurrent.CountDownLatch;

/**
 * Created by dima on 15.03.17.
 */

class Student extends Thread{
    CountDownLatch countDownLatch;

    public Student(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        System.out.println("student is waiting for food");
        try {
            countDownLatch.await();
            System.out.println("student is eating");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Chef extends Thread{
    CountDownLatch countDownLatch;

    public Chef(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        System.out.println("the chef is cooking");
        try {
            Thread.sleep(200);
            countDownLatch.countDown();
            System.out.println("the chef has cooked");
        } catch (InterruptedException e) {
        }
    }
}

public class CountDown {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Student student = new Student(countDownLatch);
        Chef chef1 = new Chef(countDownLatch);
        Chef chef2 = new Chef(countDownLatch);
        student.start();
        chef1.start();
        chef2.start();
    }
}
