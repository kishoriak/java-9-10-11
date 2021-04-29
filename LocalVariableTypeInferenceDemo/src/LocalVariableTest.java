import static java.util.Map.entry;

import java.util.List;
import java.util.Map;
public class LocalVariableTest {
	public static void main(String[] args) {
		//allowed with initialization
		var warningCount =5;;
		
		var message = "Hello, Java 10";
	    System.out.println("Check message type is String :" +message instanceof String);
		
		/*List<String> cities = List.of("Brussels", "Cardiff", "Cambridge");
		Map<String, Integer> citiesPopulation= Map.ofEntries(entry("Brussels", 1_139_000),
															entry("Cardiff", 341_000));*/
		var cities = List.of("Brussels", "Cardiff", "Cambridge");
		var citiesPopulation= Map.ofEntries(entry("Brussels", 1_139_000),
															entry("Cardiff", 341_000));
		
		
	}

}
