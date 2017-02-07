/**
 * Created by dima on 07.02.17.
 */

//for clone need to implements Cloneable
class A {
    int a;
    int[] mass;
    public A(){
    }
    public A(A pa){
    }

    //Shallow copy
    /*public A clone(){
        A copy = new A();
        copy.a = this.a;
        copy.mass = this.mass;
        return copy;
    }*/

    //Deep copy
    /*public A clone(){
        A copy = new A();
        copy.a = this.a;
        copy.mass = this.mass.clone();
        return copy;
    }*/

    //Object could not be cloned
    public A clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}

public class Main {
}
