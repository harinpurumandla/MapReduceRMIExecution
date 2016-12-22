/*RMI server*/
import java.rmi.*;
import java.rmi.server.*; 
public class RMIServer {
	public static void main (String[] argv) {
		   try {
		
			   System.setSecurityManager(new RMISecurityManager()); // creating the security manager

			   RMIC rmi = new RMIC();// creating the object for RemoteCommuniation		   		   
			   Naming.rebind("rmi://localhost/ABC", rmi); // bind the object with a name 
			   
			   System.out.println("Server is ready."); // output the status of server
			   }catch (Exception e) {
				   System.out.println("Server failed: " + e);
				}
		   }
}
