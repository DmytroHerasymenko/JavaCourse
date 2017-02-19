package behavioral;

/**
 * Created by dima on 19.02.17.
 */
class TV {
    State state;
    public TV (){
        state = new SwitchOff(this);
    }

    public void switchOn(){
        state.switchOn();
    }
    public void switchOff(){
        state.switchOff();
    }

    public void changeChanal(String ch){
        state.changeChanal(ch);
    }
}

abstract class State{
    TV tv;

    public State(TV tv){
        this.tv = tv;
    }

    public void switchOn(){
        System.out.println("we can not switch on the TV");
    }
    public void switchOff(){
        System.out.println("we can not switch off the TV");
    }
    public void changeChanal(String ch){
        System.out.println("we can not change chanal");
    }
}

class SwitchOn extends State{
    public SwitchOn(TV tv){
        super(tv);
    }
    public void switchOff(){
        tv.state = new SwitchOff(tv);
    }
    public void changeChanal(String ch){
        System.out.println("we change chanal to" + ch);
    }
}

class SwitchOff extends State{
    public SwitchOff(TV tv){
        super(tv);
    }

    public void switchOn(){
        tv.state = new SwitchOn(tv);
    }
}
public class StatePattern {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.switchOff();
        tv.changeChanal("1+1");
        tv.switchOn();
        tv.changeChanal("1+1");

    }
}
