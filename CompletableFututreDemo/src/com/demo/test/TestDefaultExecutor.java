package com.demo.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class TestDefaultExecutor {
	
	public static void main(String[] args) {
		Executor executor = new CompletableFuture<>().defaultExecutor();
		CompletableFuture nameFuture = CompletableFuture.supplyAsync(() -> "Rajan", executor);

		// Should be avoided, only for demonstration purpose
		System.out.println(nameFuture.join());
	}
	

}
