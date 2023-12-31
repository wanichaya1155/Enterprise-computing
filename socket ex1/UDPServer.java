import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class UDPServer {
    public static void main(String[] args) throws Exception{

        DatagramSocket serverSocket = new DatagramSocket(2024);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        Date currentDate = new Date();
        while (true) {

            DatagramPacket receivPacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivPacket);

            String sentence = new String(receivPacket.getData());
            System.out.println(sentence);

            InetAddress ipAddress = receivPacket.getAddress();
            int port = receivPacket.getPort();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss G");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            
            sendData = formattedDateTime.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, ipAddress, port);
            serverSocket.send(sendPacket);
     
        }
    }
}
