/*
 * How to run remote method invocation
 * Server side:
 * - Compile the server class
 * 		javac RemoteInvocationServer.java -d .
 * - Register server class to rmic
 * 		rmic Constructs.RemoteInvocationServer
 * - Run rmiregistry (Command needs to be entered in the same directory as the compiled class file)
 * 		rmiregistry
 * - Run the server program
 * 		java Constructs.RemoteInvocationServer
 * 
 * Client side:
 * - Compile the client class
 * 		javac RemoteInvocationClient.java -d .
 * - Run the client program
 * 		java Constructs.RemoteInvocationClient
 */

package Constructs;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

interface MyRemote extends Remote {
	public String sayHello() throws RemoteException; 
}

// Implementation class
public class RemoteInvocationServer extends UnicastRemoteObject implements MyRemote {
	public RemoteInvocationServer() throws RemoteException {}
	public String sayHello() {
		return "Hello!!!";
	}
	
	public static void main(String args[]) {
		try {
			MyRemote service = new RemoteInvocationServer();
			Naming.rebind("RemoteHello", service);
		}
		catch (Exception ex) {
			//System.out.println("error");
			ex.printStackTrace();
		}
	}
}
