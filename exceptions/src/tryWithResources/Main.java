package tryWithResources;

import java.io.Closeable;

/**
 * Created by dima on 11.02.17.
 */
class A implements Closeable {
    public void close(){
        System.out.println("close");
    }
    public void f(int a){
        if(a==0){
            throw new RuntimeException();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        //try-with-resources
        try (A pa = new A()) {
            pa.f(0);
        }
        //equivalent realization
        A pa1 = new A();
        try {
            pa1.f(0);
        } finally {
            pa1.close();
        }
    }
}
