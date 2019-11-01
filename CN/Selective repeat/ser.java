import java.io.*;
import java.net.*;
import java.util.*;

public class ser
{
	public static void main(String args[])throws IOException
	{
		System.out.println("Initating Server...");
		System.out.println("Waiting for connection from Client");
		InetAddress addr = InetAddress.getByName("Localhost");
		ServerSocket ss = new ServerSocket(500);


		Socket client = new Socket();
		client=ss.accept();

		BufferedInputStream in = new BufferedInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		System.out.println("Request Recived from client for sending frames");
		int p = in.read();

		boolean f[] = new boolean[p];

		int pc = in.read();
		System.out.println("Sending...");
		if(pc == 0)
		{
			for(int i=0;i<p;++i)
			{
				System.out.println("\nSending frame number: "+i);
				out.write(i);
				out.flush();
				System.out.println("Waiting for acknowledgement.");
				try
				{
					Thread.sleep(7000);
				}
				catch(Exception e){}
				int a = in.read();
				System.out.println("Received acknowledgement for frame "+i+" as "+a);
			}
			out.flush();
		}
		else
		{
			for(int i=0;i<=p;++i)
			{
				if( i == p)
				{
					break;
				}
				if(i==2)
				{
					System.out.println("\nSending frame number: "+i);
					System.out.println("Waiting for acknowledgement.");
					try
					{
						Thread.sleep(3000);
					}
					catch(Exception e){}
					System.out.println("No acknowledgement Received.");

				}
				else
				{
					System.out.println("\nSending frame number: "+i);
					out.write(i);
					out.flush();
					System.out.println("Waiting for acknowledgement.");
					try
					{
						Thread.sleep(7000);
					}
					catch(Exception e){}

					int a = in.read();
					
					System.out.println("Received acknowledgement for frame "+a);
					f[a]=true;
					
				}
			}


			
			for(int i=0;i<p;i++)
			{
				if(f[i] != true)
				{
					System.out.println("\nReSending frame number: "+i);
					out.write(i);
					out.flush();
					System.out.println("Waiting for acknowledgement.");
					try
					{
						Thread.sleep(5000);
					}
					catch(Exception e){}

					int b = in.read();
					System.out.println("Received acknowledgement for frame "+b);
					f[b]=true;
				}
			}
		}


		in.close();
		out.close();
		client.close();
		ss.close();
		System.out.println("Quitting");
	}
}