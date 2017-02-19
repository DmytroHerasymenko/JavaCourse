package behavioral;

/**
 * Created by dima on 19.02.17.
 */
class A{
    Mediator m;
    public void sendMessage(String message, Class c){
        m.send(message, c);
    }
    public void recieveMessage(String message){
        System.out.println(message);
    }
    public void setM(Mediator m) {
        this.m = m;
    }
}

class B {
    Mediator m;

    public void sendMessage(String message, Class c){
        m.send(message, c);
    }
    public void recieveMessage(String message){
        System.out.println(message);
    }
    public void setM(Mediator m) {
        this.m = m;
    }
}

class C{
    Mediator m;

    public void sendMessage(String message, Class c){
        m.send(message, c);
    }
    public void recieveMessage(String message){
        System.out.println(message);
    }

    public void setM(Mediator m) {
        this.m = m;
    }
}

class Mediator{
    A pa;
    B pb;
    C pc;
    public void setA(A pa){
        this.pa = pa;
    }
    public void setB(B pb){
        this.pb = pb;
    }
    public void setC(C pc){
        this.pc = pc;
    }

    public void send(String message, Class c){
        switch (c.getName()){
            case "A" : pa.recieveMessage(message);
                break;
            case "B" : pb.recieveMessage(message);
                break;
            case "C" : pc.recieveMessage(message);
                break;
        }
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        A pa = new A();
        B pb = new B();
        C pc = new C();

        mediator.setA(pa);
        mediator.setB(pb);
        mediator.setC(pc);

        pa.setM(mediator);
        pb.setM(mediator);
        pc.setM(mediator);

        pa.sendMessage("asdfsdf", B.class);
    }
}
