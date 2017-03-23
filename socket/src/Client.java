import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by dima on 23.03.17.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5555);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String s = "hello server";
        outputStream.write(s.getBytes());
        byte[] buf = new byte[1024];
        int count = inputStream.read(buf);
        String answer = new String(buf,0,count);
        System.out.println(answer);
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
