/**
 *
 * @author ashut
 */
import java.net.*;
import java.io.*;
public class dclient {
           public static void main(String args[])throws IOException
            {
                        byte b[]=new byte[3072];
                        DatagramSocket dsoc=new DatagramSocket(1000);
                        FileWriter f=new FileWriter("C:\\Users\\ashut\\Documents\\nm.txt");
                        BufferedWriter buf =new BufferedWriter(f);
                        while(true)
                        {
                                    DatagramPacket dp=new DatagramPacket(b,b.length);
                                    dsoc.receive(dp);
                                    String s=new String(new String(dp.getData(),0,dp.getLength())); 
                                    if(s.trim().equals("END"))
                                        break;
                                    buf.write(s);
                        }
                        buf.close();
            }
}
