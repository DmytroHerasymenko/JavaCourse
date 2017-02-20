package behavioral;

/**
 * Created by dima on 20.02.17.
 */

abstract class Strategy{
    abstract void sort();
}

class InsertSort extends Strategy{
    public void sort(){
        System.out.println("insertSort");
    }
}

class QuickSort extends Strategy{
    public void sort(){
        System.out.println("quickSort");
    }
}

public class StrategyPattern {
    public static void f(Strategy strategy){
        strategy.sort();
    }
    public static void main(String[] args) {
        Strategy strategy = new InsertSort();
        f(strategy);
    }
}
