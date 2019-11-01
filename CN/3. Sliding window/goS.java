import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;

public class goS
{
	public static void main(String ar[])throws IndexOutOfBoundsException
	{
		ServerSocket serverSocket= new ServerSocket("localhost",3333);
		Socket socket=serverSocket.accept();
		DataInputStream in=new DataInputStream(socket.getInputeStream());
		DataOutputStream out=new DataOutputStream(socket.getOutputStream());
		BufferedReader br=new BufferedReader(socket.getInputeStream());
		
	}
}