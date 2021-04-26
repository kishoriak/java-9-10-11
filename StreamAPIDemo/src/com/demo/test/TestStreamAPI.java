package com.demo.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI {
	      
        public static void takeWhileOperation() {
        	/*Stream<String> s1=Stream.iterate("x", s -> s + "s");
        	s1.forEach(System.out::println);*/
        	
            List<String> list = Stream.iterate("x", s -> s + "s").takeWhile(s -> s.length() < 10)
            		            .collect(Collectors.toList());

            System.out.println("length : "+ list.size());  //10

            System.out.println("Value at 0  : "+ list.get(0));  ///x
            System.out.println("Value at 2  : "+  list.get(2)); //xss
            System.out.println("Value at last position  : "+list.get(list.size() - 1)); //"xsssssssss"
        }

        
        public static void dropWhileOperation() {
            List<String> list = Stream.iterate("x", s -> s + "s").takeWhile(s -> s.length() < 10)
            		     .dropWhile(s -> !s.contains("sssss"))
            		     .collect(Collectors.toList());

            System.out.println("Size  : "+  list.size());  //5

            System.out.println("Value at 0  : "+  list.get(0));
            System.out.println("Value at 2  : "+  list.get(2));
            System.out.println("Value at last position  : "+ list.get(list.size() - 1));
        }

               
        public static void testIterateOperation() {
        	Stream<Integer> intStream=Stream.iterate(0, i -> i < 10, i -> i + 1);  //will return stream with 0 to 9
            List<Integer> list = intStream.collect(Collectors.toList());

            System.out.println("size :"+ list.size());

            System.out.println("Value at 0 :"+  list.get(0));
            System.out.println("Value at 5 :"+  list.get(5));
            System.out.println("Value at last position :"+  list.get(list.size() - 1));
        }

        //java 9
        private static Stream<Integer> java9TestNullable() {
        	List<String> collection = Arrays.asList("A", "B", "C");
            Map<String, Integer> map = new HashMap<>() {
	                {
	                    put("A", 10);
	                    put("C", 30);
	                }
            };
            Stream data= collection.stream().flatMap(s -> Stream.ofNullable(map.get(s)));
            
            return data;
        }

      //java 8 style
        private static Stream<Integer> java8TestNullable() {
        	List<String> collection = Arrays.asList("A", "B", "C");
            Map<String, Integer> map = new HashMap<>() {
	                {
	                    put("A", 10);
	                    put("C", 30);
	                }
            };
            
            //flatmap return a stream of data that contains one or more values
            
            return collection.stream().flatMap(s -> {
                Integer temp = map.get(s);
                return temp != null ? Stream.of(temp) : Stream.empty();
            });
        }

        private static List<Integer> displayData(Stream<Integer> stream) {
            List<Integer> list = stream.collect(Collectors.toList());

            System.out.println("size :"+  list.size()); 

            System.out.println("Value at 0 :"+  list.get(0));  //10
            System.out.println("Value last position :"+  list.get(list.size() - 1)); //30

            return list;
        }

       
     

    
	public static void main(String[] args) {
		
		//takeWhileOperation();
		//dropWhileOperation();
		//testIterateOperation();
		displayData(java8TestNullable());
		displayData(java9TestNullable());
	}

}
