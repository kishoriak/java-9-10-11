public class MultipleNestTest {
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
}