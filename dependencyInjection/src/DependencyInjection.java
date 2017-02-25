import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by dima on 25.02.17.
 */

interface MyInterface{
    void f();
}

class A {
    MyInterface myInterface;

    public void g(){
        myInterface.f();
    }
}

class B implements MyInterface {
    public void f(){
        System.out.println("B");
    }
}

class C implements MyInterface{
    public void f(){
        System.out.println("C");
    }
}

class Factory {
    public static A getInstance(String fileName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] elements = bufferedReader.readLine().split(":");
        bufferedReader.close();
        Class ca = Class.forName(elements[0]);
        A pa = (A) ca.newInstance();
        Field f = ca.getDeclaredField(elements[1]);
        f.setAccessible(true);
        Class c = Class.forName(elements[2]);
        Object o = c.newInstance();
        f.set(pa, o);
        return pa;
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, IOException {
        A pa = Factory.getInstance("config.txt");
        pa.g();
    }
}
