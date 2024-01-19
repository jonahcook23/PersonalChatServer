import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServerThread implements Runnable {

    private int port;
    ServerSocket server;
    Socket socket;
    ArrayList<UserThread> users = new ArrayList<>();

    public MainServerThread(int p) {
        port = p;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                socket = server.accept();
                UserThread user = new UserThread(socket);
                users.add(user);
                new Thread(user).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}