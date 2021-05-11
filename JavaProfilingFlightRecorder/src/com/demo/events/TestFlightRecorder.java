package com.demo.events;
import java.util.ArrayList;
import java.util.List;

public class TestFlightRecorder {

	public static void main(String[] args) {
		List<Object> mylist=new ArrayList<>();
		try {
			while(true) {
			mylist.add(new Object());
			}
		}catch(OutOfMemoryError e) {
			System.out.println(e.getMessage());
		}
        assert mylist.size()>0;
        try {
        	Thread.sleep(10000);
        }catch(InterruptedException e) {
        	System.out.println(e.getMessage());
        }
        System.out.println("end of main");
	}

}
