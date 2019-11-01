import java.io.*;
import java.net.*;
import java.math.*;
import java.util.*;

class cli
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("LocalHost");
		System.out.println("Server: "+addr);

		Socket connection = new Socket(addr,500);

		BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		Scanner scr = new Scanner(System.in);

		System.out.println("Initaing Client...");
		System.out.println("Establishing connection...");
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e){}
		System.out.println("Connected");
		System.out.println("Enter the number of frame the server should send: ");
		int c = scr.nextInt();

		out.write(c);
		out.flush();

		System.out.println("\nEnter type of transmission\n0.No Error\n1.With Error\nEnter Your Choice: ");
		int choice = scr.nextInt();
		out.write(choice);

		int check=0;
		int i=0;
		int j=0;
		boolean f[] = new boolean[c];

		if(choice == 0)
		{
			for(j=0;j<c;++j)
			{
				i = in.read();
				System.out.println("\nReceived frame number: "+i);
				System.out.println("Sending acknowledgement for frame "+i);
				out.write(i);
				out.flush();
			}
			out.flush();
		}
		else
		{
			for(j=0;j<=c;++j)
			{
				if( j == c)
				{
					break;
				}
				i = in.read();
				System.out.println("\nReceived frame number: "+i);
				System.out.println("Sending acknowledgement for frame "+i);
				out.write(i);
				f[i]=true;
				out.flush();
			}

		}

		in.close();
		out.close();
		System.out.println("Quitting");
	}
}