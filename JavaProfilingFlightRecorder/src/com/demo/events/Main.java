package com.demo.events;

public class Main {

    public static void main(String[] args) {
	MyEvent event=new MyEvent();
	event.begin();
	event.message="This is msg from custom event";
	event.commit();

    }
}
