import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by dima on 15.03.17.
 */
class Writer extends Thread{
    Lock lock;
    Queue<Integer> queue;

    public Writer(Lock writeLock, Queue<Integer> queue){
        this.lock = writeLock;
        this.queue = queue;
    }

    public void run(){
        lock.lock();
        queue.add(10);
        lock.unlock();
    }
}

class Reader extends Thread{
    Lock lock;
    Queue<Integer> queue;

    public Reader(Lock readLock, Queue<Integer> queue){
        this.lock = readLock;
        this.queue = queue;
    }

    public void run(){
        lock.lock();
        queue.peek();
        lock.unlock();
    }

}

public class ReadWrite {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Queue<Integer> queue = new LinkedList<>();
        Writer writer = new Writer(readWriteLock.writeLock(), queue);
        Reader reader1 = new Reader(readWriteLock.readLock(), queue);
        Reader reader2 = new Reader(readWriteLock.readLock(), queue);

        writer.start();
        reader1.start();
        reader2.start();

    }
}
