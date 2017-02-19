package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 19.02.17.
 */
class Observable{
    int value;
    List<Observer> observers = new ArrayList<Observer>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setValue(int newValue){
        for(Observer o : observers){
            o.notify(value, newValue);
        }
        value = newValue;
    }
}

interface Observer{
    void notify(int oldValue, int newValue);

}
class MyObserver implements Observer{
    public void notify(int oldValue, int newValue){
        System.out.println(oldValue);
        System.out.println(newValue);
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        Observable observable = new Observable();
        MyObserver myObserver = new MyObserver();
        MyObserver myObserver1 = new MyObserver();

        observable.addObserver(myObserver);
        observable.addObserver(myObserver1);
        observable.setValue(100);
    }
}
