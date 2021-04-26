package com.demo.test;

import java.util.concurrent.*; 
public class TestOnExit 
 { 
 public static void main(String[] args) throws Exception 
 { 
	 ProcessBuilder pb=new ProcessBuilder("java","FrameDemo"); 
	 Process p=pb.start(); 
	 System.out.println("Process Started with id:"+p.pid()); 
	 CompletableFuture<Process> future=p.onExit(); 
	 future.thenAccept(p1->System.out.println("Process Terminated with Id:"+p1.pid())); 
	 System.out.println(future.get()); 
 } 
 } 