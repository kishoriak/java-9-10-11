import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestClass {

	public static void main(String[] args) {
		//Map<Integer, String> map = new HashMap<>();
		var map = new HashMap<Integer, String>();
		System.out.println("Type of map :"+map.getClass().getName());
		
		
		//var emptyList = null; // error: variable initializer is 'null'
		
		//var p = (String s) -> s.length() > 10; // error: lambda expression needs an explicit target-type
       Predicate<String> p=(s)->s.length()>10;
       
       //var arr = { 1, 2, 3 };  //error array initializers need explicite type
       int[] arr = { 1, 2, 3 }; 
	}

}
