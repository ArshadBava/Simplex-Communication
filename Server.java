import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // Create server socket on port 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for a connection...");

            // Accept connection from client
            clientSocket = serverSocket.accept();
            System.out.println("Connection established with client: " + clientSocket.getInetAddress());

            // Send data to client (simplex communication)
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            String message = "Hello from the server!";
            writer.println(message);
            System.out.println("Message sent to client: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}