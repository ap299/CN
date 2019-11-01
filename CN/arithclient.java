import java.io.*;
import java.net.*;
import java.util.*;

class arithclient
{
	public static void main(String args[])throws IOException
	{
		InetAddress addr = InetAddress.getByName("Localhost");
		Socket conn = new Socket(addr,500);

		BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		Scanner scr = new Scanner(System.in);

		int num1,num2,res,ch;
		
			System.out.println("Enter First number: ");
			num1 = scr.nextInt();
			out.write(num1);
			out.flush();
			System.out.println("Enter Second number: ");
			num2 = scr.nextInt();
			out.write(num2);
			out.flush();

			System.out.println("Select arithmatic operation: ");
			System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n");
			ch = scr.nextInt();
			out.write(ch);
			out.flush();

			
			res = in.read();
			System.out.println("The result is: "+res);
			
		
		
		in.close();
		conn.close();
	}
}