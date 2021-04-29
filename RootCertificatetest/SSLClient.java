
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLSocketFactory;
import javax.net.SocketFactory;
import java.io.*;
import java.util.Scanner;

public class SSLClient  {
  public static void main(String[] args) throws IOException {
    SocketFactory fact = SSLSocketFactory.getDefault();
    Socket conn = fact.createSocket("localhost", 1234);
    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
    DataInputStream in = new DataInputStream(conn.getInputStream());
    System.out.println("handshake done");
    out.writeUTF("Hello");
	System.out.println("Client : Hello");
	Scanner sc=new Scanner(System.in);
	String str=in.readUTF();
	System.out.println("Server: "+str);
	System.out.println("Client :");
	String msg=sc.next();
    while (!msg.equals("end")) {
		out.writeUTF(msg);
		 str=in.readUTF();
		 if(str.equals("end"))
		     break;
	    System.out.println("Server: "+str);
		System.out.println("Client :");
	    msg=sc.next();
      
    }
    in.close();
    out.close();
    conn.close();
  }
}
