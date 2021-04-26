package com.demo.test;
import java.util.Optional;
import java.util.function.*;
public class Java9OptionalOr {

	public static void main(String[] args) {
		Optional<String> opStr = Optional.of("Rams");
				//opStr ==> Optional[Rams]

				
		Supplier<Optional<String>> supStr = () -> Optional.of("No Name");
				//supStr ==> $Lambda$67/222624801@23faf8
		Optional<String> s1=opStr.or(supStr);
				//$5 ==> Optional[Rams]
		System.out.println(s1.get());
		//example2

		Optional<String> opStr1 = Optional.empty();
//opStr ==> Optional.empty

		Supplier<Optional<String>> supStr1 = () -> Optional.of("No Name");
//supStr ==> $Lambda$67/222624801@23faf8f2

		Optional<String> s=opStr1.or(supStr1);
		System.out.println(s.get());
//$7 ==> Optional[No Name]

	}
	

}
