import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Duplexer {

    Socket socket;
    BufferedReader input;
    PrintWriter output;

    public Duplexer(Socket s) {
        socket = s;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String s) {
        output.println(s);
        output.flush();
    }

    public String receive() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
