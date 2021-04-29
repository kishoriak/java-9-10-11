import java.util.Iterator;
import java.util.Map;

public class TestClass12 {
    public static void removematches(Map<? extends String,? extends Number> map,int n) {
    	for(Iterator<? extends Map.Entry<? extends String,? extends Number>> iterator=map.entrySet().iterator();iterator.hasNext();) {
    			Map.Entry<? extends String,? extends Number> entry=iterator.next();
    			if(entry.getKey().equals("end")) {
    				iterator.remove();
    			}
    		
    	}
    	
    	for(var iterator=map.entrySet().iterator();iterator.hasNext();) {
			var entry=iterator.next();
			if(entry.getKey().equals("end")) {
				iterator.remove();
			}
		
	}
    }
	public static void main(String[] args) {
		

	}

}
