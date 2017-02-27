/**
 * Created by dima on 27.02.17.
 */

class Sum extends Thread {
    private int begin;
    private int end;
    private long result;

    public Sum(int begin, int end){
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

public class ExtendsThread {
    public static void main(String[] args) throws InterruptedException {
        Sum sum1 = new Sum(1, 50000);
        Sum sum2 = new Sum(50000, 100001);

        sum1.start();
        sum2.start();
        sum1.join();
        sum2.join();
        long total = sum1.getResult() + sum2.getResult();
        System.out.println(total);
    }
}


