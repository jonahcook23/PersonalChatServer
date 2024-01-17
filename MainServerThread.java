import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServerThread implements Runnable {

    private int port;
    ServerSocket server;
    Socket socket;

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
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}