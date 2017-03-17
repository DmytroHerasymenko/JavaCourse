/**
 * Created by dima on 15.03.17.
 */
public class Barrier{
    int count;

    public Barrier(int count){
        this.count = count;
    }

    public void await() throws InterruptedException {
        synchronized (this){
            count--;
            while (count > 0){
                this.wait();
            }
            this.notifyAll();
        }
    }
}
