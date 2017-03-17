/**
 * Created by dima on 17.03.17.
 */
class Dychotomia extends Thread{
    double a;
    double b;
    double eps;
    double result;

    public Dychotomia(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public static double f(double x){
        return x-2;
    }

    public void run(){
        if(Math.abs(a-b) > eps){
            double c = (a+b)/2;
            if(f(a) * f(c) <= 0){
                Dychotomia dychotomia = new Dychotomia(a, c, eps);
                dychotomia.start();
                try {
                    dychotomia.join();
                    result = dychotomia.result;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Dychotomia dychotomia = new Dychotomia(c, b, eps);
                dychotomia.start();
                try {
                    dychotomia.join();
                    result = dychotomia.result;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            result = a;
        }
    }
}

public class Dychotomy {
    public static void main(String[] args) throws InterruptedException {
        Dychotomia dychotomia = new Dychotomia(0,4,0.01);
        dychotomia.start();
        dychotomia.join();
        System.out.println(dychotomia.result);

    }
}

