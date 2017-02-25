import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dima on 25.02.17.
 */
interface A {
    int f(int a, int b);
}

class B implements A {

    @Override
    public int f(int a, int b) {
        return a + b;
    }
}

class MyProxy implements InvocationHandler {
    private A pa;

    public MyProxy(A pa){
        this.pa = pa;
    }

    public A getInstance(){
        return (A) java.lang.reflect.Proxy.newProxyInstance(pa.getClass().getClassLoader(), pa.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("f")){
            int a = (int) args[0] * 2;
            int b = (int) args[1] * 2;
            return method.invoke(pa, a, b);
        }
        return method.invoke(pa, args);
    }
}

public class Proxy {
    public static void main(String[] args) {

        MyProxy p = new MyProxy(new B());
        A pa = p.getInstance();
        int res = pa.f(10,20);
        System.out.println(res);
    }
}
