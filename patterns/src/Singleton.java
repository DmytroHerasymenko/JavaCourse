/**
 * Created by dima on 15.02.17.
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){
    }
    public static Singleton getInstance(){
        /*if(instance == null){
            instance = new Singleton();
        }*/
        return instance;
    }
}
