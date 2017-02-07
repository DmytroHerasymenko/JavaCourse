/**
 * Created by dima on 07.02.17.
 */
class A{
    int aa = 40;
    public C fA(){
        int a = 10;
        a = 110;
        class B implements C{
            int b = 20;

            public void fB() {
                a = 100;
            }
        }
        B pb = new B();
        return pb;
    }
}

interface C{
    public void fB();
}

public class Main {
    public static void main(String[] args) {
        A pa = new A();
        C o = pa.fA();
        o.fB();
    }
}
