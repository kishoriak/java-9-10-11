package com.demo.test;



import java.util.stream.Stream;

public class TestAllProcesses {

	public static void main(String[] args) {
		Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        liveProcesses.filter(ProcessHandle::isAlive).forEach(ph -> {
        	    System.out.println("-------------------");
                System.out.println("pid : "+ph.pid());
                System.out.println("start time : "+ph.info().startInstant());
                System.out.println("User : "+ph.info().user().get());
                System.out.println("command : "+ph.info().command().get());
                  
            });
        
        long count=ProcessHandle.allProcesses()
        .filter(ph -> (ph.pid() > 10000 && ph.pid() < 50000))
        .count();
        System.out.println("count :" + count);

	}

}
