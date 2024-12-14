import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // Connect to the server on localhost and port 12345
            socket = new Socket("localhost", 12345);
            System.out.println("Connected to the server.");

            // Receive data from server (simplex communication)
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String message = reader.readLine();
            System.out.println("Message received from server: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}