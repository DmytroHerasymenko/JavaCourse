package structural;

/**
 * Created by dima on 19.02.17.
 */

class Car{
    protected void switchEngine(){
    }
    protected void pushClutch(){
    }
    protected void pushGas(){
    }

    public void move(){
        switchEngine();
        pushClutch();
        pushGas();
    }
}

public class Fasade {
}
