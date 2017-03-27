import java.io.*;

/**
 * Created by dima on 27.03.17.
 */
class A1 implements Externalizable {
    int a;
    int b;
    transient int c;

    public A1() {
    }

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
    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(a);
        out.writeInt(b);
        out.writeInt(c);
        System.out.println("write");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        a = in.readInt();
        b = in.readInt();
        c = in.readInt();
        System.out.println("read");
    }
}

public class OverrideExternalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        A1 myClass = new A1();
        myClass.setA(10);
        myClass.setB(20);
        myClass.setC(30);
        File file = new File("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(myClass);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        A1 myClass1 = (A1) objectInputStream.readObject();
        System.out.println(myClass1.getA());
        System.out.println(myClass1.getB());
        System.out.println(myClass1.getC());
        objectInputStream.close();
        fileInputStream.close();
    }
}