import java.net.*;
import java.io.*; 
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.net.ServerSocket; 


public class Server {
	public static void main(String args[])throws Exception{  

		ServerSocket ss=new ServerSocket(3333);  
		// ClientWorker w=new ClientWorker(ss.accept());
		
		Socket s=ss.accept(); 
		Thread t=new Thread(s);
		t.start(); 
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=din.readUTF();  
			System.out.println("client says: "+str);  
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}}   
	


