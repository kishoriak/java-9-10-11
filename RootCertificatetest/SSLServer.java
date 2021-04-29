
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.util.Scanner;

public class SSLServer  {
  public static void main(String[] args) throws IOException {

    ServerSocketFactory fact = SSLServerSocketFactory.getDefault();
    ServerSocket listen = fact.createServerSocket(1234);

    System.out.println("Wating for client.... at 1234");
    Socket connection = listen.accept();
    Scanner sc=new Scanner(System.in);
    while (connection != null)  {
    	
      DataInputStream in = new DataInputStream(connection.getInputStream());
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());

      String c;
	  c=in.readUTF();
	  System.out.println("Client : "+c);
      while (!c .equals("end")) {
		System.out.println("Client : "+c);
		System.out.println("Server: ");
		String str=sc.next();
        out.writeUTF(str);
		c=in.readUTF();
      }
			out.close();
			in.close();
			connection.close();
    }
  }
}
