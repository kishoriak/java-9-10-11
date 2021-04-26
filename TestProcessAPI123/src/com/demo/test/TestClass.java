package com.demo.test;

import java.util.Optional;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		ProcessHandle ph=ProcessHandle.current();
		
		long pid=ph.pid();
		System.out.println("pid of current process :"+pid);
		Thread.sleep(1000);
		ProcessHandle.Info info=ph.info();
		System.out.println("complete info "+info);
		System.out.println("user :"+info.user().get());  //user method returns optional and get method return the object wrapped inside optional
		System.out.println("user :"+info.command().get());
		System.out.println("cputime :"+info.totalCpuDuration().get());
	    Optional<String[]> larg=info.arguments();  //get process arguments if any
	    Optional<String> comdarg =info.command();   //get process commandline arguments  if any
	    Optional<String> cmd=info.command();    //get executeables path name
	    System.out.println("start time : "+info.startInstant().get());  //returns start time of the process
	    
	    

	}

}
