/*
Remote method implementor
*/
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashSet;
import java.io.*;
public class RMIC extends UnicastRemoteObject implements RMIInterface{
	public RMIC () throws RemoteException {  
		super(); // super to handle the remote exception
	}
	public HashSet<String> getLocations() 
	{
		HashSet<String> hs=new HashSet<String>();
		hs.add("");
	    InputStream is = null; 
	    InputStreamReader isr = null;
	    BufferedReader br = null;
	    try{
	         is = new FileInputStream("Table2.in"); // open Table2.in file
	         
	         // create new input stream reader
	         isr = new InputStreamReader(is);
	         
	         // create new buffered reader
	         br = new BufferedReader(isr);
	      
	         String Line="";
	         
	         // reads to the end of the stream 
	         while ((Line = br.readLine()) != null) { // read each line
	        	 String[] parts = Line.split("<SEP>"); // split the line with a <SEP> as delimiter 
	        	 String[] locations = parts[3].split("<I>");// split the location with a <I> as delimiter 
        		 for(String l: locations)
        		 hs.add(l); //add the value to hash set
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
		return hs; // returning hashset
	}
	public HashSet<String> getArtist(String location)
	{
		HashSet<String> hs=new HashSet<String>();
	    InputStream is = null; 
	    InputStreamReader isr = null;
	    BufferedReader br = null;
	    try{
	         is = new FileInputStream("Table2.in");// open Table2.in file
	         
	         // create new input stream reader
	         isr = new InputStreamReader(is);
	         
	         // create new buffered reader
	         br = new BufferedReader(isr);
	      
	         String Line="";
	         
	         // reads to the end of the stream 
	         while ((Line = br.readLine()) != null) {// read each line
	        	 String[] parts = Line.split("<SEP>");// split the line with a <SEP> as delimiter 
	        	 
	        	 if(parts[3].toLowerCase().contains(location.toLowerCase())) // checking if the location sent to this method matches with the location for each line of file
	        	 {
	        		 
	        		 hs.add(parts[2]); // if matched add the artist name to the hash set
	        	 }
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
		return hs; // returning hashset
	}
	public int getSongCount(String location)
	{
		int count=0;
		HashSet<String> hs=new HashSet<String>();
	    InputStream is = null; 
	    InputStreamReader isr = null;
	    BufferedReader br = null;
	    try{
	         is = new FileInputStream("Table2.in");// open Table2.in file
	         
	         // create new input stream reader
	         isr = new InputStreamReader(is);
	         
	         // create new buffered reader
	         br = new BufferedReader(isr);
	      
	         String Line="";
	         
	         // reads to the end of the stream 
	         while ((Line = br.readLine()) != null) {// read each line
	        	 String[] parts = Line.split("<SEP>");// split the line with a <SEP> as delimiter 
	        	 if(parts[3].toLowerCase().contains(location.toLowerCase()))// checking if the location sent to this method matches with the location for each line of file
	        	 {
	        		 String[] songs = parts[4].split("<I>");
	        		 count += songs.length; // counting the number of songs for the selected line and adding to a variable count
	        	 }
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
		return count; //returning count
	}
	
	
}
