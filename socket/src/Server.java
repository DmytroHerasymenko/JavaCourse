import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dima on 23.03.17.
 */
class ClientHandler extends Thread {
    Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {

            byte[] buf = new byte[1024];

            int count = inputStream.read(buf);
            String s = new String(buf, 0, count);
            s+= " from server";
            outputStream.write(s.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555, 5, InetAddress.getByName("0.0.0.0"));
        while (true){
            Socket clientSocket = serverSocket.accept();
            ClientHandler ch = new ClientHandler(clientSocket);
            ch.start();

        }
    }
}
