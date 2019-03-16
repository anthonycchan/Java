package Constructs;

import java.io.*;
import java.net.*;

public class Server extends Thread {

	private ServerSocket serverSocket;
	
	public Server() {
		// TODO Auto-generated constructor stub
	}

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket();
		serverSocket.bind( new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1} ), port) );
//		serverSocket.setSoTimeout(1000);
	}
	
	public void run() {
		while (true) {
			try{
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort());
				
				// Blocks for connection
				Socket server = serverSocket.accept();
				
				System.out.println("Client address: " + server.getRemoteSocketAddress().toString() );
				
				// Message from Client
				InputStream input = server.getInputStream();
				DataInputStream inputFromClient = new DataInputStream(input);
				System.out.println( inputFromClient.readUTF() );
				
				// Message to Client
				OutputStream output = server.getOutputStream();
				DataOutputStream outputToClient = new DataOutputStream(output);
				outputToClient.writeUTF("Server: Server response");
				
				server.close();
			}
			catch ( IOException exp ) {
				System.out.println("run: " + exp.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Server svr = new Server(1234);
			svr.start();
		}
		catch (IOException exp){
			System.out.println(exp.toString());
		}
	}
}
