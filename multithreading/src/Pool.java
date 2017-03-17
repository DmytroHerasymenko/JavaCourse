import java.util.concurrent.*;

/**
 * Created by dima on 17.03.17.
 */
class Sum3 implements Callable<Integer> {
    Integer begin;
    Integer end;

    public Sum3(Integer begin, Integer end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for(int i=begin; i < end; i++){
            result +=i;
        }
        return result;
    }
}

public class Pool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Sum3 sum1 = new Sum3(0,5000);
        Sum3 sum2 = new Sum3(5000, 7001);
        Sum3 sum3 = new Sum3(7001, 10001);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(sum1);
        Future<Integer> future2 = executorService.submit(sum2);
        Future<Integer> future3 = executorService.submit(sum3);
        while (!(future1.isDone() && future2.isDone() && future3.isDone())){
            System.out.println("other task");
        }
        Integer total = future1.get() + future2.get() + future3.get();
        future1.isDone();
        System.out.println(total);
        executorService.shutdown();

    }
}
