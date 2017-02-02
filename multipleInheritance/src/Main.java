/**
 * Created by dima on 01.02.17.
 */

interface A{
    public final static int a = 10;
    public abstract void f();
    default void g(){
    }
}

class C{
    public void g(){
    }
}

class B extends C implements A{
    public void f(){
    }
}

public class Main {
    public static void main(String[] args) {
        B pb = new B();
        pb.g();
    }
}