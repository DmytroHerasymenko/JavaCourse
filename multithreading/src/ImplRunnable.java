/**
 * Created by dima on 27.02.17.
 */

class Summ implements Runnable {
    private int begin;
    private int end;
    private long result;

    public Summ(int begin, int end){
        this.begin = begin;
        this.end = end;
        this.result = 0;
    }

    @Override
    public void run(){
        for(int i = begin; i < end; i++){
            result += i;
        }
    }

    public long getResult() {
        return result;
    }

}

public class ImplRunnable {
    public static void main(String[] args) throws InterruptedException {
        Summ sum1 = new Summ(1, 50000);
        Summ sum2 = new Summ(50000, 100001);

        Thread thread1 = new Thread(sum1);
        Thread thread2 = new Thread(sum2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long total = sum1.getResult() + sum2.getResult();
        System.out.println(total);
    }
}