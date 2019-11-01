
import java.net.*;
import java.io.*;
public class dserver {
   
  public static void main(String args[])throws Exception
            {         
                        byte b[]=new byte[3000];
                        FileInputStream f=new FileInputStream("C:\\old.txt");
                        DatagramSocket dsoc=new DatagramSocket(2000);
                        int i=0;
                        while((i=f.read(b))!=-1)
                        {
                            dsoc.send(new DatagramPacket(b,b.length,InetAddress.getLocalHost(),1000));
                            if(i==0)
                            {
                                b="END".getBytes();
                                dsoc.send(new DatagramPacket(b,b.length,InetAddress.getLocalHost(),1000));
                            }
                        }
                        f.close();
                        
            }