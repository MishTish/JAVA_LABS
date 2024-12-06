import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverIPAddress = InetAddress.getByName(serverAddress);
            Scanner scanner = new Scanner(System.in);

            System.out.println("UDP Client is ready. Type 'bye' to exit.");

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
                byte[] sendBuffer = message.getBytes();


                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverIPAddress, serverPort);
                clientSocket.send(sendPacket);


                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + serverResponse);

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Exiting...");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}