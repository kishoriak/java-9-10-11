import java.util.List;
import java.util.stream.Collectors;

import com.demo.bean.Product;

public class VarCollectionsDemo {

	public static void main(String[] args) {
		var products = List.of(
			    new Product(10, 3, "Apple"),
			    new Product(5, 2, "Banana"),
			    new Product(17, 5, "Pear"));
		System.out.println("Products type : "+products.getClass().getName());
		
		
		var productInfos = products
			    .stream()
			    .map(product -> new Object() {
			        String name = product.getName();
			        int total = product.getStock() * product.getValue();
			    })
			    .collect(Collectors.toList());
		
		productInfos.forEach(prod ->
			    System.out.println("name = " + prod.name + ", total = " +
			prod.total));
		
		System.out.println("ProductInfos type : "+productInfos.getClass().getName());

	}

}
