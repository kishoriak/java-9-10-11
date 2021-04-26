package com.demo.test;

import java.util.Optional;




public class Java8OptionalMethods {

	
	  public static void main(String[] args)
	  {
	    
	    Optional<Integer> opt1 = division(4,2);    
	    opt1.ifPresent( x -> System.out.println("Option1: Result found = " + x));

	    Optional<Integer> opt2 = division(4,0);    
	    opt2.ifPresent( x -> System.out.println("Option2: Result found: " + x));
	    
	    System.out.println("Option2: Result not found, default vlaue = " + opt2.orElse(new Integer(0)));

	    if(opt2.isPresent())
	      System.out.println("Option2: Result found.");
	    else
	      System.out.println("Option2: Result not found.");
	    
	  }

	  public static Optional<Integer> division(Integer i1,Integer i2)
	  {
	    if(i2 == 0) return Optional.empty();
	    else {
	       Integer i3 = i1/i2;
	       return Optional.of(i3);
	    }
	  

	}
}