package com.demo.test;

abstract class MyAbstractClass<T> {
    abstract T add(T num1, T num2);
    public int subtract(int n1,int n2) {
    	return n1+n2;
    }
}

public class TestDiamondOperator {

	 public static void main(String[] args)
		    {
		        //diamond operator for inner annonymous class will
		        //work in java 9 but not in java 8
		    	MyAbstractClass<Integer> obj = new MyAbstractClass<>() {
		            Integer add(Integer n1, Integer n2)
		            {
		                return (n1 + n2);
		            }
		        };
		        Integer result = obj.add(10, 20);
		        int sub=obj.subtract(23,10);
		        System.out.println("Addition of two numbers: " + result);
		        System.out.println("Subtraction of two numbers: " + sub);
		    }
}
