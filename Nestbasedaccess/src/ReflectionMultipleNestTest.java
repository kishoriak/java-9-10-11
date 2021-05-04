import java.util.stream.Stream;

public class ReflectionMultipleNestTest {
    private int x=10;
	private int y=20;
    private  int add(){
	 return x+y;
	     
	};

    class NestedClass1 {

        public  void innerPublic() {
            add();
        }
    }
	 class NestedClass2 {

        public  void innerPublic() {
            add();
        }
    }
	
	public static void main(String[] args){
		findNests(ReflectionMultipleNestTest.class);
		findHost(ReflectionMultipleNestTest.class);
		findHost(ReflectionMultipleNestTest.NestedClass1.class);
		checkNestMates(ReflectionMultipleNestTest.NestedClass1.class,ReflectionMultipleNestTest.NestedClass2.class);
	}
	
	public static void findNests(Class<?> className){
		System.out.println("class Name : "+className.getSimpleName());
		System.out.println("Nest members : ");
		Class<?>[] members=className.getNestMembers();
		Stream.of(members).map(Class::getName).forEach(System.out::println);
		
	}
	
	public static void findHost(Class<?> className){
		System.out.println("class Name : "+className.getSimpleName());
		System.out.println("Host  Name : ");
		Class<?> hostClass=className.getNestHost();
		System.out.println("Host class is : "+hostClass.getSimpleName());
		
		
	}
	
	public static void checkNestMates(Class<?> class1,Class<?> class2) {
		boolean check=class1.isNestmateOf(class2);
		System.out.println(class1.getName()+"is nestmate of "+class2.getName()+":  "+check);
	}
}
