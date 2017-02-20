package behavioral;

/**
 * Created by dima on 20.02.17.
 */

class Common{
    public void algorithm(){
        System.out.println("commonPart");
    }

}

class AlgorithmA extends Common{
    public void algorithm(){
        super.algorithm();
        System.out.println("Algorithm a");
    }
}

class AlgorithmB extends Common{
    public void algorithm(){
        super.algorithm();
        System.out.println("Algorithm b");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Common common = new AlgorithmA();
        common.algorithm();
    }
}
