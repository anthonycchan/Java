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

import java.rmi.Naming;

public class RemoteInvocationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoteInvocationClient().go(); 
	}

	public void go() {
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			String s = service.sayHello();
			System.out.println(s);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
