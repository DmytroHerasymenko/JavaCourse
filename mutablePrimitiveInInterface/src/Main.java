/**
 * Created by dima on 07.02.17.
 */
interface A {

    class B{
        int x = 10;
    }
    B pb = new B();

}

public class Main {
    public static void main(String[] args) {
        A.pb.x = 300;
    }
}
