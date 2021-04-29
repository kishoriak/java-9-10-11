import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestVar11 {

	public static void main(String[] args) {
		/*List<Integer> list=List.of(12,13,14);
		for(Integer i:list) {
			System.out.println(i);
		}*/
		
		var list=List.of(12,13,14);
		for(var i:list) {
			System.out.println(i);
		}
		System.out.println("Type of list :"+list.getClass().getName());
        list=new ArrayList<>();
        
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("abc.txt"))){
        	
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
try(var bufferedReader=new BufferedReader(new FileReader("abc.txt"))){
        	
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
final var name="Rajan";
        //name="xxx";

        var list1=new ArrayList<>();
        // list1=List.of("aaa","xxx");
        
	}

}
