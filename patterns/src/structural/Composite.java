package structural;

/**
 * Created by dima on 15.02.17.
 */
abstract class Component{
    public abstract int calculate();
}

class Number extends Component {
    int value;
    public Number(int value){
        this.value = value;
    }
    public int calculate(){
        return value;
    }
}

class OperationPlus extends Component {
    Component left;
    Component right;
    public OperationPlus(Component left, Component right){
        this.left = left;
        this.right = right;
    }
    public int calculate(){
        return left.calculate()+right.calculate();
    }
}

class OperationMulty extends Component {
    Component left;
    Component right;
    public OperationMulty(Component left, Component right){
        this.left = left;
        this.right = right;
    }

    public int calculate(){
        return left.calculate()*right.calculate();
    }
}

class TreeFactory{
    public static Component getCalculateTree(){
        Component plus1 = new OperationPlus(new Number(1),new Number(2));
        Component multy1 = new OperationMulty(plus1, new Number(3));
        Component multy2 = new OperationMulty(new Number(4), new Number(5));
        Component plus2 = new OperationPlus(multy1,multy2);
        return plus2;
    }
}

public class Composite {
    public static void main(String[] args) {
        Component c = TreeFactory.getCalculateTree();
        System.out.println(c.calculate());
    }
}
