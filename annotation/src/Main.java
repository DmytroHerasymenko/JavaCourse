import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by dima on 25.02.17.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}

class A {
    @MyAnnotation(value = "Hello")
    public void f(){
        Class c = this.getClass();
        try {
            Method f = c.getDeclaredMethod("f");
            MyAnnotation m = f.getAnnotation(MyAnnotation.class);
            System.out.println(m.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        /*Class c = Class.forName("A");
        MyAnnotation m = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
        System.out.println(m.value());*/

        A pa = new A();
        pa.f();
    }
}
