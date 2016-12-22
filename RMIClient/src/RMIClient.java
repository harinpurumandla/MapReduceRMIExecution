import java.rmi.*;
import java.util.*;
public class RMIClient {
	public static String[] getLocation()
	{
		RMIInterface rmi; // creating a remote object of the interface
		HashSet<String> result=new HashSet<String>();
		try {
			 if (System.getSecurityManager() == null)  // if the manager is null 
  		        System.setSecurityManager(new RMISecurityManager()); // create the security manager
			rmi = (RMIInterface)Naming.lookup("rmi://localhost/ABC"); // looking for the RMI name
			result=rmi.getLocations(); // calling remote method getLocaiton
			}catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
				}
		TreeSet<String> tset = new TreeSet<String>(result); // sorting the result
		String out[] = tset.toArray(new String[tset.size()]); // converting the result to array of strings
				return out;
	}
	public static HashSet<String> getArtist(String Location)
	{
		RMIInterface rmi;// creating a remote object of the interface
		HashSet<String> result=new HashSet<String>();
		try {
			 if (System.getSecurityManager() == null) // if the manager is null
  		        System.setSecurityManager(new RMISecurityManager());// create the security manager
			rmi = (RMIInterface)Naming.lookup("rmi://localhost/ABC");// looking for the RMI name
			result=rmi.getArtist(Location);// calling remote method getArtist
			}catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
				}
		return new HashSet<String>(result); //returning result
	}

	public static int getSongCount(String Location)
	{
		RMIInterface rmi;// creating a remote object of the interface
		int result=0;
		try {
			 if (System.getSecurityManager() == null) // if the manager is null 
  		        System.setSecurityManager(new RMISecurityManager());// create the security manager
			rmi = (RMIInterface)Naming.lookup("rmi://localhost/ABC");// looking for the RMI name
			result=rmi.getSongCount(Location);// calling remote method getSongCount
			}catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
				}
		return result;
	}
	
	
}