package com.demo.test;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		ProcessHandle ph=ProcessHandle.current();
		long pid=ph.pid();
		System.out.println("pid of current process :"+pid);
		Thread.sleep(1000);
		ProcessHandle.Info info=ph.info();
		System.out.println("complete info "+info);
		System.out.println("user :"+info.user().get());
		System.out.println("user :"+info.command().get());
		System.out.println("cputime :"+info.totalCpuDuration().get());
		
	}

}
