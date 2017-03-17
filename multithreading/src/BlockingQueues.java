import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dima on 15.03.17.
 */

class A implements Delayed {
    int value;
    long delayTime;

    public A(int value, int delayTime) {
        this.value = value;
        this.delayTime = delayTime + System.currentTimeMillis();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), unit);
    }
    @Override
    public int compareTo(Delayed o) {

        return Long.compare(this.delayTime, ((A)o).delayTime);
    }
}

class MyThread6 extends Thread{
    SynchronousQueue<Integer> synchronousQueue;

    public MyThread6(SynchronousQueue<Integer> synchronousQueue){
        this.synchronousQueue = synchronousQueue;
    }
    public void run(){
        try {
            System.out.println(synchronousQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BlockingQueues {
    public static void main(String[] args) throws InterruptedException {
        /*Queue<Integer> queue = new ArrayBlockingQueue<Integer>(2);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

        /*Queue<Integer> queue1 = new LinkedBlockingQueue<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());*/

        /*A pa1 = new A(300, 1000);
        A pa2 = new A(200, 1500);
        A pa3 = new A(100, 2000);
        Queue<A> queue2 = new DelayQueue<>();
        queue2.offer(pa1);
        queue2.offer(pa2);
        queue2.offer(pa3);
        while (true){
            Thread.sleep(500);
            A element = queue2.poll();
            System.out.println(element == null ? null : element.getValue());
        }*/

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        MyThread6 myThread = new MyThread6(synchronousQueue);
        myThread.start();
        synchronousQueue.put(12);

        System.out.println("asdasdasdasdasdasdasdasd");
        synchronousQueue.put(13);
    }
}
