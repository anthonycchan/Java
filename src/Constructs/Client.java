package Constructs;

import java.io.*;
import java.net.*;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		if ( args.length != 2 )
			return;
		
		System.out.println("Client");
		
		String host = args[0];
		int port = Integer.parseInt( args[1] );
		
		try {
			Socket client = new Socket();
			client.connect(new InetSocketAddress( InetAddress.getByName(host), port), 1000 );
			
			// Message to server
			OutputStream out = client.getOutputStream();
			DataOutputStream outToServer = new DataOutputStream(out);
			outToServer.writeUTF("Send To Server: " + client.getInetAddress().toString() + " : " + client.getPort());
			
			// Message from server
			InputStream in = client.getInputStream();
			DataInputStream inFromServer = new DataInputStream(in);
			System.out.println( inFromServer.readUTF() );
			
			System.out.println("Client: " + client.getInetAddress().toString() + " " + client.getPort() + " " + client.getLocalPort());
			client.close();
		}
		catch(IOException exp) {
			System.out.println(exp.toString());
		}
	}

}
