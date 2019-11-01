import java.io.*;
import java.net.*;
import java.util.*;

class chatserver
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		ServerSocket ss = new ServerSocket(500);
		Socket client = new Socket();
		client = ss.accept();

		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		Scanner scr = new Scanner(System.in);

		String s1="";
		String s2="";

		while(!s1.equals("Stop"))
		{
			s1 = in.readUTF();
			System.out.println("Client message: "+s1);
			System.out.println("Your Message: ");
			s2 = scr.nextLine();
			out.writeUTF(s2);
			out.flush();
		}
		in.close();
		ss.close();
		client.close();
	}
}