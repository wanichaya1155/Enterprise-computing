import java.io.*;
import java.net.*;
class TCPClient{
    public static void main(String[] args) throws Exception{
        int clientnum1; 
        int clientnum2; 
        int ans;
        Socket clienSocket = null;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clienSocket = new Socket("localhost", 1667);

        DataOutputStream outToserver = new DataOutputStream(clienSocket.getOutputStream());
        DataInputStream  inFromServer = new DataInputStream(clienSocket.getInputStream());

        try{
            while (true) {
                System.out.print("enter number 1 (to end just press enter):");
                String input = inFromUser.readLine();
               
                clientnum1 = Integer.parseInt(input);
                outToserver.writeInt(clientnum1);

                System.out.print("enter number 2 (to end just press enter):");
                input = inFromUser.readLine();
              
                clientnum2  = Integer.parseInt(input);
                outToserver.writeInt(clientnum2 );

                ans = inFromServer.readInt();
                System.out.println("The result is : " + ans);
                clienSocket.close();
            }
        }
        catch (Exception e) {
            System.err.println("Closing Socket connection");
            if (clienSocket != null)
            try {
                clienSocket.close();
            } catch (IOException ex) {}
        }
    }
}