import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dima on 25.02.17.
 */
class A{
    private int a;

    public A() {
    }

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //first way to get Class
        Class c1 = A.class;
        //second way
        A pa = new A();
        Class c2 = pa.getClass();
        //third way
        Class c3 = Class.forName("A");

        Field[] fields = c3.getDeclaredFields(); //return info about protect and public methods of class A
        for(Field f : fields){
            System.out.println(f.getType());
            System.out.println(f.getName());
        }

        A pa1 = (A)c3.newInstance();
        Field f = c3.getDeclaredField("a");

        f.setAccessible(true);  //change private to public int a
        f.set(pa1, 200);
        System.out.println(pa1.getA());

        Method m = c3.getDeclaredMethod("setA", int.class );
        m.invoke(pa1, 300);
        System.out.println(pa1.getA());

        Constructor c = c3.getDeclaredConstructor(int.class);
        A pa2 = (A) c.newInstance(500);
        System.out.println(pa2.getA());

        Class c4 = Class.forName("A");
        A pa4 = (A) c1.newInstance();
        System.out.println(pa.getA());

        //declared - public fields of this class and all super classes
        Constructor constructor = c1.getDeclaredConstructor(int.class);
        A pa5 = (A) constructor.newInstance(new Integer(10));
    }
}
