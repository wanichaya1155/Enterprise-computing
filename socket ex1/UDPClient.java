import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket clienSocket = new DatagramSocket();
        BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ipAddress = InetAddress.getByName("localhost");

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.printf("Testing server communication. Type sometihing : ");
        String sentence = input.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 2024);
        clienSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clienSocket.receive(receivePacket);
        String ans = new String(receivePacket.getData());

        System.out.println("Date and Time: " + ans);
    }
}