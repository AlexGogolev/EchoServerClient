package InputOutput.FileIO.EchoServerAndClient;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(args[0], 4444);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = inu.readLine())!= null) {
           // System.out.println("client input: "+input);
            out.println(input);
            System.out.println(in.readLine());
            if (input.equalsIgnoreCase("close")) break;
            if (input.equalsIgnoreCase("exit")) break;
        }

        out.close();
        in.close();
        inu.close();
        socket.close();
    }
}
