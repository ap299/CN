import java.io.*;
import java.net.*;
import java.util.*;

class trignoclient
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		Socket conn = new Socket(addr,500);

		DataInputStream in = new DataInputStream(conn.getInputStream());
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		Scanner scr = new Scanner(System.in);


		double deg,res;
		int ch;
		System.out.println("Enter the value: ");
		deg = scr.nextDouble();
		out.writeDouble(deg);
		out.flush();
		System.out.println("Select Operation: \n1.Sin\n2.Cos\n3.Tan");
		ch = scr.nextInt();

		out.write(ch);
		out.flush();

		res = in.readDouble();
		if(ch == 1)
		{
			System.out.println("Sin("+deg+") = "+res);
		}
		else if(ch == 2)
		{
			System.out.println("Cos("+deg+") = "+res);
		}
		else if(ch == 3)
		{
			System.out.println("Tan("+deg+") = "+res);
		}
		else
		{
			System.out.println("Wrong option!");
		}
		
	}
}