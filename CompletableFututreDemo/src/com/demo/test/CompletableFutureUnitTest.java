package com.demo.test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class CompletableFutureUnitTest {
	public static void futureDelayCheck () throws Exception {
        Object input = new Object();
        CompletableFuture<Object> future = new CompletableFuture<>();
        future.completeAsync(() -> input, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
        
        Thread.sleep(100);
        
        System.out.println("Afetr delay 100  :"+future.isDone());
        
        Thread.sleep(1000);
        System.out.println("Afetr delay 1000 :"+future.isDone());
        System.out.println("check object :"+(input==future.get()));
    }

 
    public static void timeoutFutureCheck () throws Exception {
        CompletableFuture<Object> future = new CompletableFuture<>();
        future.orTimeout(1, TimeUnit.SECONDS);
        
        Thread.sleep(1100);
        
       System.out.println(future.isDone());
        
        try {
            future.get();
        } catch (ExecutionException e) {
            System.out.println("ExcetionTimeout"+(e.getCause() instanceof TimeoutException));
        }
    }

  
    public static void timeoutNotTriggeredCheck () throws Exception {
        Object input = new Object();
        CompletableFuture<Object> future = new CompletableFuture<>();
        
        future.orTimeout(1, TimeUnit.SECONDS);
        
        Thread.sleep(100);
        
        future.complete(input);
        
        Thread.sleep(1000);
        
        System.out.println("Afetr delay 1000"+future.isDone());
        System.out.println("check object"+(input==future.get()));
    }
    
    

    
    public static void completeOnTimeoutCheck() throws Exception {
        Object input = new Object();
        CompletableFuture<Object> future = new CompletableFuture<>();
        future.completeOnTimeout(input, 1, TimeUnit.SECONDS);
        
        Thread.sleep(1100);
        
        System.out.println("Aft delay 1000"+future.isDone());
        System.out.println("check object"+(input==future.get()));
    }

	public static void main(String[] args) throws Exception {
		//completeOnTimeoutCheck();
		//timeoutNotTriggeredCheck();
		//timeoutFutureCheck();   
		futureDelayCheck ();
	}
}
