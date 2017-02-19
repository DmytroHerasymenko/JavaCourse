package behavioral;

/**
 * Created by dima on 19.02.17.
 */
abstract class Handler{
    Handler handler;

    public abstract void execute(String command);

    public Handler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
class MyHandler1 extends Handler{
    public MyHandler1(Handler handler){
        super(handler);
    }
    public void execute(String command){
        if(command.equals("command1")){
            System.out.println("command1");
        } else {
            handler.execute(command);
        }
    }
}

class MyHandler2 extends Handler{
    public MyHandler2(Handler handler){
        super(handler);
    }
    public void execute(String command){
        if(command.equals("command2")){
            System.out.println("command2");
        } else {
            handler.execute(command);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler2 = new MyHandler2(null);
        Handler handler1 = new MyHandler1(handler2);
        handler1.execute("command2");
    }
}
