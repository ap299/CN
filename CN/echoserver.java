import java.io.*;
import java.net.*;
import java.util.*;

class echoserver
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

		
		while(!s1.equals("stop"))
		{
			s1 = in.readUTF();
			System.out.println("Client Says: "+s1);
			out.writeUTF(s1);
			out.flush();
		}

		in.close();
		out.close();
		ss.close();
		client.close();
	}
}