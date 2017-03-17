/**
 * Created by dima on 15.03.17.
 */
public class Semaphore{
    int count;

    public Semaphore(int count){
        this.count = count;
    }

    public void acquire() throws InterruptedException {
        synchronized (this){
            while (count == 0){
                this.wait();
            }
            count--;
        }
    }

    public void release(){
        synchronized (this){
            count++;
            this.notifyAll();
        }
    }
}
