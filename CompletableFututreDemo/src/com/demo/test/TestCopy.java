package com.demo.test;

import java.util.concurrent.CompletableFuture;

public class TestCopy {

	public static void main(String[] args) {
		CompletableFuture nameFuture = CompletableFuture.supplyAsync(() -> "Rajan");
		CompletableFuture nameFutureCopy = nameFuture.copy();
		CompletableFuture withSurname = nameFuture.thenApply(name -> name+"xxxx");

		// Should be avoided, only for demonstration purpose
		System.out.println("With adding xxx==>" + withSurname.join());

		// Change in original instance should affect it's copy instance.
		System.out.println(nameFutureCopy.join());

	}

}
