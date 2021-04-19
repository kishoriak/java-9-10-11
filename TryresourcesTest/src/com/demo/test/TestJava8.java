package com.demo.test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestJava8 {
	public static void main(String[] args) {
		    BufferedWriter br=null;
		    File f=new File("words.txt");
		    //This cannot be used in Autoclosable resources so the code has to be written in this way
		    try {
			    if(f.exists()) {
			    	br =new BufferedWriter(new FileWriter("words.txt",true));
				}
			    else {
			    	br =new BufferedWriter(new FileWriter("words.txt"));
				}
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //extra variable copy is needed in java 8
		    //but in java 9 extra variable is not needed
		    //try(dos){     /// java 9 way 
			try(BufferedWriter br1=br;){
				Scanner sc=new Scanner(System.in);
				String msg=null;
				do {
				System.out.println("enetr Message");
				msg=sc.next();
				br1.write(msg);
				}while(!msg.equals("end"));
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			 	} 
			 catch (IOException e1) {
				e1.printStackTrace();
			 	}
			
		
	}
	
	

}
