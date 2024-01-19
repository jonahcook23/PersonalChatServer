import java.net.Socket;

public class UserThread implements Runnable {

    Duplexer socket;

    public UserThread(Socket s) {
        socket = new Duplexer(s);
    }

    public void run() {
        
    }

    public void close() {
        socket.close();
    }
    
}
