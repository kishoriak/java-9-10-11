import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionAccessMultiple {
	private static int x=23;
	
	static class Nested1{
		public static void get1() {
			System.out.println(x);
		}
		public static void getX() throws NoSuchFieldException{
			Field data=ReflectionAccessMultiple.class.getDeclaredField("x");
			try {
				data.setInt(null, 100);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) throws NoSuchFieldException {
		Nested1.get1();
		Nested1.getX();
		System.out.println(ReflectionAccessMultiple.x);
		
		Set<String> nestMembers = Arrays.stream(ReflectionAccessMultiple.Nested1.class.getNestMembers())
			      .map(Class::getName)
			      .collect(Collectors.toSet());

			    is(nestMembers.size()).equals(2);

			    assertTrue(nestMembers.contains("com.demo.Outer"));
			    assertTrue(nestMembers.contains("com.demo.Outer$Inner"));

		
	}

}
