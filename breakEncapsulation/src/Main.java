/**
 * Created by dima on 07.02.17.
 */
class B{
    int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class A{
    private B pB;

    public A(B pb){
        this.pB=pb;
    }

    //breakdown of encapsulation( get access to private field)
    public B getpB() {
        return pB;
    }

    public void setpB(B pB) {
        this.pB = pB;
    }
}

public class Main {
}
