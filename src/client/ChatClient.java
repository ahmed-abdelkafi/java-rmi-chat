package client;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

import serveur.ChatInterface;
import serveur.Chat;
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {
		    	
		    	Scanner s = new Scanner(System.in);
		    	System.out.println("Entrez votre nom et appuyez sur Entrée:");
		    	String name = s.nextLine().trim();		    		    	
		    	ChatInterface client = new Chat(name);
 
		    	ChatInterface server = (ChatInterface)Naming.lookup("rmi://localhost:1900/CHAT");
		    	String msg = "["+client.getName()+"] s'est connecté";
		    	server.send(msg);
		    	System.out.println("[System] Le CHAT est prêt:");
		    	server.setClient(client);
 
		    	while(true){
		    		msg = s.nextLine().trim();
		    		msg = "["+client.getName()+"] "+msg;		    		
	    			server.send(msg);
		    	}
 
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
}