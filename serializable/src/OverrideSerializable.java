import java.io.*;

/**
 * Created by dima on 27.03.17.
 */
class A implements Serializable {
    int a;
    int b;
    transient int c;

    public A(){}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(a);
        objectOutputStream.writeInt(b);
        System.out.println("write");
    }
    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        a = objectInputStream.readInt();
        b = objectInputStream.readInt();
        System.out.println("read");
    }
}

public class OverrideSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A myClass = new A();
        myClass.setA(10);
        myClass.setB(20);
        File file = new File("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        A myClass1 = (A) objectInputStream.readObject();
        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        objectInputStream.close();
        fileInputStream.close();
    }
}