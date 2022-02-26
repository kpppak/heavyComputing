import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static final int SERVER_PORT = 10001;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);


        try (Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("New connection accepted");
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("end")) {
                    System.out.println("The connection interrupted");
                    break;
                }
                int n = Integer.parseInt (line);
                FibonacciNumber fibonacci = new FibonacciNumber();
                System.out.println(fibonacci.computeFibanacciNumber(n));
                out.println(n + "th element of Fibonacci's number sequence equals " + fibonacci.computeFibanacciNumber(n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
