import java.io.*;
import java.net.*;
import java.util.*;

class arithserver
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		ServerSocket ss = new ServerSocket(500);
		Socket client = new Socket();
		client = ss.accept();

		BufferedInputStream in = new BufferedInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		Scanner scr = new Scanner(System.in);

		int num1 = in.read();
		int num2 = in.read();
		int ch,res=0,ans;

		
			System.out.println("The two numbers recived are: "+num1+" and "+num2);
			System.out.println("Computing...");
			ch = in.read();
			switch(ch)
			{
				case 1:
				{
					res = num1+num2;
					break;
				}
				case 2:
				{
					res = num1-num2;
					break;
				}
				case 3:
				{
					res = num1*num2;
					break;
				}
				case 4:
				{
					res = num1/num2;
					break;
				}
				default:
				{
					System.out.println("Wrong option!");
				}
			}

			System.out.println("Result Sent!");
			out.write(res);
			out.flush();
		
		in.close();
		ss.close();
		client.close();
	}
}