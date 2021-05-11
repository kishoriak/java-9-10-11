import java.lang.reflect.Field;

public class ReflectionAccessMultiple {
	private static int x=23;
	
	static class Nested1{
		public static void get1() {
			System.out.println(x);
		}
		public static void getX() throws NoSuchFieldException{
			//Class cls=ReflectionAccessMultiple.getClass();
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
		
	}

}
