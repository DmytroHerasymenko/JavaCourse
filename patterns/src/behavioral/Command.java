package behavioral;

/**
 * Created by dima on 19.02.17.
 */
interface CommandInterface{
    void execute();
}

class Command1 implements CommandInterface{
    public void execute(){
        System.out.println("command1");
    }
}

class Command2 implements CommandInterface{
    public void execute(){
        System.out.println("command2");
    }
}

class CommandFactory{

    private static CommandFactory instance = new CommandFactory();

    Command1 command1 = new Command1();
    Command2 command2 = new Command2();

    public static CommandFactory getInstance(){
        return instance;
    }

    public CommandInterface getCommand(int id){
        switch (id){
            case 1: return command1;
            case 2: return command2;
            default: return null;
        }
    }
}
public class Command {
    public static void main(String[] args) {
        CommandFactory factory = CommandFactory.getInstance();
        CommandInterface c = factory.getCommand(1);
        c.execute();
    }
}
