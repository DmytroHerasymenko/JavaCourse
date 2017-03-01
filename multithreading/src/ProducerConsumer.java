import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dima on 01.03.17.
 */

class Producer extends Thread {
    private Queue<Object> queue;
    String name;
    public Producer ( Queue<Object> queue, String name){
        this.queue = queue;
        this.name = name;
    }

    public void run(){
        while (true){
            synchronized (queue) {
                while (queue.size() >= 5) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(new Object());
                System.out.println("the thread " + this.name + "put the element into the queue.");
                queue.notifyAll();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {private Queue<Object> queue;
    String name;
    public Consumer ( Queue<Object> queue, String name){
        this.queue = queue;
        this.name = name;
    }

    public void run(){
        while (true){
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                System.out.println("the thread " + this.name + "remove the element from the queue.");
                queue.notifyAll();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue = new LinkedList<>();
        Producer producer1 = new Producer(queue, "producer1");
        Producer producer2 = new Producer(queue, "producer2");
        Consumer consumer1 = new Consumer(queue, "consumer1");
        Consumer consumer2 = new Consumer(queue, "consumer2");
        Consumer consumer3 = new Consumer(queue, "consumer3");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.join();
    }
}
