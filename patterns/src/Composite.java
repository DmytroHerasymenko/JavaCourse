/**
 * Created by dima on 15.02.17.
 */
abstract class Component{
    public abstract int calculate();
}

class Number extends Component1 {
    int value;
    public Number(int value){
        this.value = value;
    }
    public int calculate(){
        return value;
    }
}

class OperationPlus extends Component1 {
    Component1 left;
    Component1 right;
    public OperationPlus(Component1 left, Component1 right){
        this.left = left;
        this.right = right;
    }
    public int calculate(){
        return left.calculate()+right.calculate();
    }
}

class OperationMulty extends Component1 {
    Component1 left;
    Component1 right;
    public OperationMulty(Component1 left, Component1 right){
        this.left = left;
        this.right = right;
    }

    public int calculate(){
        return left.calculate()*right.calculate();
    }
}

class TreeFactory{
    public static Component1 getCalculateTree(){
        Component1 plus1 = new OperationPlus(new Number(1),new Number(2));
        Component1 multy1 = new OperationMulty(plus1, new Number(3));
        Component1 multy2 = new OperationMulty(new Number(4), new Number(5));
        Component1 plus2 = new OperationPlus(multy1,multy2);
        return plus2;
    }
}

public class Composite {
    public static void main(String[] args) {
        Component1 c = TreeFactory.getCalculateTree();
        System.out.println(c.calculate());
    }
}
