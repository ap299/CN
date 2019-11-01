import java.io.*;
import java.net.*;
import java.util.*;

class echoclient
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		Socket conn = new Socket(addr,500);
		

		DataInputStream in = new DataInputStream(conn.getInputStream());
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		Scanner scr = new Scanner(System.in);

		String s1="";
		String s2="";

		
		while(!s1.equals("stop"))
		{
			System.out.println("Enter your Message : ");
			s2 = scr.nextLine();
			out.writeUTF(s2);
			out.flush();
			s1 = in.readUTF();
			System.out.println("Server Says: "+s1);
		}

		in.close();
		out.close();
		conn.close();
	}
}