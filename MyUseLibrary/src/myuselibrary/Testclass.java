package myuselibrary;

import mylibrarymodule.MyClass;

public class Testclass {
	//@SuppressWarnings({ "deprecation", "removal" })
	public static void main(String[] args) {
		MyClass ob=new MyClass(12,13);
		System.out.println("Addition  : "+ob.add());

	}

}
