package com.demo.test;

import java.util.Optional;

public class Java9OptionalMethod {

	public static void main(String[] args) {
		// ifPresentOrElse
	Optional<Integer> opt1 = Optional.of(4);
				//opt1 ==> Optional[4]

	opt1.ifPresentOrElse( x -> System.out.println("Result found: " + x), () -> System.out.println("Not Found."));
				//Result found: 4

	Optional<Integer> opt2 = Optional.empty();
		//opt2 ==> Optional.empty

	opt2.ifPresentOrElse( x -> System.out.println("Result found: " + x), () -> System.out.println("Not Found."));
				//Not Found.

	}

}
