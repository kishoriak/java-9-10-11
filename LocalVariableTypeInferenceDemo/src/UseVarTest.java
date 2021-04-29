import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UseVarTest {

	public static void main(String[] args) {
		List<String> list=List.of("aaa","bbb","ccc");
		for(String s:list) {
			System.out.println(s);
		}
		
		for(var s:list) {
			System.out.println(s);
		}
		/*---------------------------------*/
		try(BufferedReader br=new BufferedReader(new FileReader("abc.txt"));){
			
		}catch(IOException e) {
			
		}
        try(var br=new BufferedReader(new FileReader("abc.txt"));){
			
		}catch(IOException e) {
			
		}
        
        //---------------------------------------------
        List<String> list1=new ArrayList<>();
         list1=List.of("aaa","bbb","ccc");
         
         var list2=new ArrayList<>();
         //list2=List.of("aaa","bbb","ccc"); //error
         
         final var name="Rajas";
         //name="test"; //error
         
	}

}
