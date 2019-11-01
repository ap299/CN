/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashut
 */
import java.net.*;
import java.io.*;
public class fileserver {
    public static void main(String args[])throws Exception{
        ServerSocket sock=new ServerSocket(2000);
        Socket ss=new Socket();
        ss=sock.accept();
        FileInputStream fin;
        fin = new FileInputStream("C:\\Users\\ashut\\Downloads\\images\\foot.png");
        byte b[]=new byte[2002];
        OutputStream out=ss.getOutputStream();
        fin.read(b, 0,b.length);
        out.write(b, 0, b.length);
        System.out.println("File transfered");
    }
}
