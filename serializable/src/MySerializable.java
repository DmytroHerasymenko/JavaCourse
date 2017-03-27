import java.io.*;

/**
 * Created by dima on 23.03.17.
 */
class MyClass implements Serializable {
    int a;
    int b;

    public MyClass(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class MySerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyClass myClass = new MyClass(10,20);
        File file = new File("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        MyClass myClass1 = (MyClass) objectInputStream.readObject();
        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        objectInputStream.close();
        fileInputStream.close();
    }
}