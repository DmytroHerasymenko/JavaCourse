import java.lang.ref.*;
/**
 * Created by dima on 07.02.17.
 */
class A{
}
public class Main {
    public static void main(String[] args) {
        //strong reference
        A pa = new A();

        //soft reference
        Reference<A> rs = new SoftReference<>(pa);
        pa = null;
        System.gc();
        A pa1 = rs.get();
        if(pa1 == null){pa1 = new A();}

        //weak reference
        Reference<A> rw = new WeakReference<>(pa1);
        pa1 = null;
        System.gc();

        //phantom reference
        A pa3 = new A();
        ReferenceQueue rq = new ReferenceQueue();
        Reference<A> rf = new PhantomReference<>(pa3,rq);
        pa3 = null;
        System.out.println(rq.poll());
        System.gc();
        System.gc();
        try {Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(rq.poll());
    }
}
