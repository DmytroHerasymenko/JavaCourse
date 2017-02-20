package behavioral;

/**
 * Created by dima on 20.02.17.
 */
class Acceptor{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

interface Visitor{
    void visit(Acceptor a);
}

class MyVisitor implements Visitor{
    public void visit(Acceptor a){
        System.out.println("myVisitor");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor();
        Visitor visitor = new MyVisitor();
        acceptor.accept(visitor);
    }
}
