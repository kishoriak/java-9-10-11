package com.demo.test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStreamTest {

	public static void main(String[] args) {
		    // given
		  Optional<String> value = Optional.of("a");
		 // Optional<List<String>> oplist=Optional.of(List.of("Kishori","Rajan"));
		    // when
		  List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());
          
		 
		    // then
		    System.out.println(collect);
		}


	

}
