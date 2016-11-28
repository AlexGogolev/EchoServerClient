package InputOutput.FileIO.EchoServerAndClient;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socketClient = null;

        System.out.println("connection on server...");
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("connection sure");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("waiting for a client...");
        try {
            socketClient = serverSocket.accept();
            System.out.println("client connection");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);

        String input;

        while ((input = in.readLine()) != null) {
            out.println("Answer server ::: " + input);
            System.out.println("from client: " + input);
        }

        out.close();
        in.close();
        socketClient.close();
        serverSocket.close();

    }
}
