import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 15.02.17.
 */
abstract class Component1 {
    abstract public int operation(int a, int b);
}

class Summ extends Component1 {
    public int operation(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;}
}

class ProxySumm extends Component1 {
    Component1 component1 = new Summ();
    Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
    public int operation(int a, int b){
        Integer result = cache.get(new Pair<>(a, b));
        if(result == null){
            result = component1.operation(a, b);
            cache.put(new Pair<>(a, b), result);
        }
        return result;
    }
}

public class Proxy {
    public static void main(String[] args) {
        Component1 c = new ProxySumm();
        c.operation(10,20);
        System.out.println("boom");
        c.operation(10,20);
        System.out.println("esche");
    }
}
