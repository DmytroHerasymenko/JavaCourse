import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dima on 15.03.17.
 */
class Producer6 extends Thread{
    Queue<Integer> queue;
    Lock l;
    Condition condition;

    public Producer6(Queue<Integer> queue, Lock l, Condition condition){
        this.queue = queue;
        this.l = l;
        this.condition = condition;
    }

    public void run(){
        l.lock();
        while (queue.size() > 5){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        l.unlock();
    }

}

class Consumer6 extends Thread{
    Queue<Integer> queue;
    Lock l;
    Condition condition;

    public Consumer6(Queue<Integer> queue, Lock l, Condition condition){
        this.queue = queue;
        this.l = l;
        this.condition = condition;
    }

    public void run(){
        l.lock();
        while (queue.size() == 0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        l.unlock();
    }
}

public class MyLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Queue<Integer> queue = new LinkedList<>();
        Producer6 producer = new Producer6(queue, lock, condition);
        Consumer6 consumer1 = new Consumer6(queue, lock, condition);
        Consumer6 consumer2 = new Consumer6(queue, lock, condition);
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
