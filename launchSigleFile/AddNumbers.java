

public class AddNumbers {

    public static void main(String[] args) {
		B b=new B();
		b.m1();
        int sum=0; 
        for(int i=0;i<args.length;i++){
			sum+=Integer.parseInt(args[i]);
		}
        System.out.println("Addition : "+sum);
    }

}

abstract class A{
	public int x=23;
}

class B extends A{
	public void m1(){
		System.out.println(x);
	}
}