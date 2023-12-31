
import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        int clientnum1;
        int clientnum2;
        int ans = 0;
        final int port = 1667;
        ServerSocket welcomeSocket = new ServerSocket(port);
      
        System.out.println("Waiting for client connection at port number " + port);
        Socket connectionSocket = welcomeSocket.accept();
                
        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        clientnum1 = inFromClient.readInt();
        clientnum2 = inFromClient.readInt();
        ans = clientnum1 + clientnum2;
        outToClient.writeInt(ans);
    }
}