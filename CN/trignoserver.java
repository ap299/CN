import java.io.*;
import java.net.*;
import java.util.*;

class trignoserver
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		ServerSocket ss = new ServerSocket(500);
		Socket client = new Socket();
		System.out.println("Server Initialized...");
		System.out.println("Waiting for connection...");
		client = ss.accept();

		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e){}

		System.out.println("Connection Established.");

		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());


		double deg,sinval,cosval,tanval;
		deg = in.readDouble();
		System.out.println("Value received is: "+deg);
		int ch;
		ch = in.read();
		switch(ch)
		{
			case 1:
			{
				double rad = Math.toRadians(deg);
				sinval = Math.sin(rad);
				out.writeDouble(sinval);
				break;
			}
			case 2:
			{
				double rad = Math.toRadians(deg);
				cosval = Math.cos(rad);
				out.writeDouble(cosval);
				break;
			}
			case 3:
			{
				double rad = Math.toRadians(deg);
				tanval = Math.tan(rad);
				out.writeDouble(tanval);
				break;
			}

			default:
			{
				System.out.println("Wrong option!");
			}
		}

		in.close();
		out.close();
		ss.close();
		client.close();
		System.out.println("Qutting!");
	}
}