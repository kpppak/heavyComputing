import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int SERVER_PORT = 10000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", SERVER_PORT);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("\nTo interrupt connection, please type 'end'");
                System.out.println("To get to know n-th element of the sequence enter a natural number");
                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equals("end")) {
                    break;
                }
                System.out.println("Server: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
