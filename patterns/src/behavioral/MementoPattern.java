package behavioral;

/**
 * Created by dima on 19.02.17.
 */
class Aa{
    int a;
    int b;
    int c;
    int d;

    public Aa(int a, int b) {
        this.a = a;
        this.b = b;
        this.c = a + b;
        this.d = a - b;
    }

    public Memento saveState(){
        Memento m = new Memento(a, b);
        return m;
    }
    public void restoreState(Memento memento){
        this.a = memento.getA();
        this.b = memento.getB();
        this.c = a + b;
        this.d = a - b;
    }
}

class Memento{
    int a;
    int b;

    public Memento(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
public class MementoPattern {
    public static void main(String[] args) {
        Aa pa = new Aa(10, 20);
        Memento memento = pa.saveState();
        pa = null;
        Aa pa1 = new Aa(0,0);
        pa1.restoreState(memento);
    }
}
