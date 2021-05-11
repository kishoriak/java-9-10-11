package com.demo.events;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("MyEvent")
@Description("Create custom event")
public class MyEvent extends Event {
    @Label("Message")
    String message;
}
