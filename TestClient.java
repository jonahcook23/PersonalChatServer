import java.net.Socket;
import java.io.IOException;

public class TestClient {

    int port;
    Duplexer socket;

    public TestClient(int p) {
        port = p;
        try {
            socket = new Duplexer(new Socket("localhost", port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String s) {
        System.out.println("client sent " + s);
        socket.send(s);
    }

    public String receive() {
        String s = socket.receive();
        System.out.println("client got " + s);
        return s;
    }

    public void close() {
        socket.close();
    }

    public static void main(String[] args) {
        int port = 18203;
        new Thread(new MainServerThread(port)).start();
    }

}