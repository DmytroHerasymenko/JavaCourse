import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by dima on 17.03.17.
 */
class Dychotomia3 extends RecursiveTask<Double> {
    double a;
    double b;
    double eps;

    public static double f(double x){
        return x-2;
    }

    public Dychotomia3(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    @Override
    public Double compute() {
        if(Math.abs(a-b) < eps){
            return a;
        }
        double c = (a+b)/2;
        if(f(a) * f(c) <= 0){
            Dychotomia3 dychotomia = new Dychotomia3(a,c,eps);
            dychotomia.fork();
            return dychotomia.join();
        } else{
            Dychotomia3 dychotomia = new Dychotomia3(c,b,eps);
            dychotomia.fork();
            return dychotomia.join();
        }
    }
}

public class ForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Dychotomia3 dychotomia = new Dychotomia3(-5, 5, 0.01);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Double> future = forkJoinPool.submit(dychotomia);
        System.out.println(future.get());
        forkJoinPool.shutdown();

    }
}
