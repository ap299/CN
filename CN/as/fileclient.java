/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashut
 */
import java.io.*;
import java.net.*;
public class fileclient {
    public static void main(String args[])throws Exception{
       Socket s=new Socket("localhost",2000);
       InputStream ins=s.getInputStream();
       FileOutputStream fous=new FileOutputStream("C:\\Users\\ashut\\Documents\\foot.png");
       byte b[]=new byte[2002];
       ins.read(b,0,b.length);
       fous.write(b, 0, b.length);
       System.out.println("File received");
    }
    
}
