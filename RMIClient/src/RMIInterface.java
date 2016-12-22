/*Stub interface for remote communication*/
import java.rmi.*;
import java.util.*;
public interface RMIInterface extends Remote {
	public HashSet<String> getLocations() throws RemoteException;
	public HashSet<String> getArtist(String location) throws RemoteException;
	public int getSongCount(String location) throws RemoteException;
}
