package com.demo.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TestCompletebaleFuture {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	CompletableFuture<String> comFuture=CompletableFuture.supplyAsync(new Supplier<String>() {
	    @Override
	    public String get() {
	        try {
	            TimeUnit.SECONDS.sleep(1000);
	        } catch (InterruptedException e) {
	            throw new IllegalStateException(e);
	        }
	        return "Result of the asynchronous computation";
	    }
	}).thenApply(msg->msg.toUpperCase());
	
	System.out.println("continue working");
	System.out.println("continue working");
	Thread.sleep(1000);
	comFuture.orTimeout(23, TimeUnit.SECONDS);
	//comFuture.completeOnTimeout("xxx",23,TimeUnit.SECONDS);
	System.out.println("value : "+comFuture.get());
}

}
