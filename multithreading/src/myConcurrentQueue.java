import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dima on 06.03.17.
 */

class MyConcurrentLinkedQueue {
    AtomicReference<Node> first = new AtomicReference<Node>(null);
    AtomicReference<Node> last = new AtomicReference<Node>(null);
    AtomicInteger size = new AtomicInteger(0);

    private static class Node{
        int data;
        Node next;
    }

    public void add(int data){
        Node node = new Node();
        node.data = data;

        while (true){
            Node head = first.get();
            //Node tail = last.get();
            if(head == null){
                if(first.compareAndSet(head, node)){
                    last.set(node);
                    size.incrementAndGet();
                    break;
                } else continue;
            }
            node.next = head;
            if(first.compareAndSet(head, node)){
                size.incrementAndGet();
                break;
            } else{
                node.next = null;
                continue;
            }
        }
    }

    public Integer remove(){
        while (true){
            Node head = first.get();
            Node tail = last.get();

            if(tail == null) return null;
            if(head == tail){
                if(first.compareAndSet(head, null)){
                    last.set(null);
                    size.decrementAndGet();
                    return head.data;
                } else continue;
            }
            Node temp = head;
            while (temp != null && temp.next != tail){
                temp = temp.next;
            }
            if(temp == null) {

                continue;
            }
            if(last.compareAndSet(temp.next, temp)){
                temp.next = null;
                size.decrementAndGet();
                System.out.println("success");
                return tail.data;
            } else continue;
        }
    }
}

class Producer1 extends Thread {
    MyConcurrentLinkedQueue myConcurrentLinkedQueue;
    public Producer1(MyConcurrentLinkedQueue myConcurrentLinkedQueue){
        this.myConcurrentLinkedQueue = myConcurrentLinkedQueue;
    }
    public void run(){
        for(int i = 0; i < 200000; i++){
            myConcurrentLinkedQueue.add(i);
        }
    }
}

class Consumer1 extends Thread{
    MyConcurrentLinkedQueue myConcurrentLinkedQueue;
    public Consumer1(MyConcurrentLinkedQueue myConcurrentLinkedQueue){
        this.myConcurrentLinkedQueue = myConcurrentLinkedQueue;
    }
    public void run(){
        int i = 0;
        while (i < 100000){
            if(myConcurrentLinkedQueue.remove() != null) {
                i++;

            }
        }
    }

}

public class myConcurrentQueue {
    public static void main(String[] args) throws InterruptedException {
        MyConcurrentLinkedQueue myConcurrentLinkedQueue = new MyConcurrentLinkedQueue();
        Producer1 producer1 = new Producer1(myConcurrentLinkedQueue);
        Producer1 producer2 = new Producer1(myConcurrentLinkedQueue);
        Consumer1 consumer1 = new Consumer1(myConcurrentLinkedQueue);
        Consumer1 consumer2 = new Consumer1(myConcurrentLinkedQueue);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();
        System.out.println(myConcurrentLinkedQueue.size.get());


    }
}
