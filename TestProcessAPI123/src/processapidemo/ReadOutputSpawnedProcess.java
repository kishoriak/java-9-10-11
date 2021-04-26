package processapidemo;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadOutputSpawnedProcess {
	
		public static void main(String[] args) throws IOException {
			 Runtime.getRuntime()
             .exec("javac -cp src src/processapidemo/OutputStreamExample.java"
                     .replace("/", File.separator));

     Process process = Runtime.getRuntime()
             .exec("java -cp src processapidemo.OutputStreamExample"
             .replace("/", File.separator));
		BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = output.readLine();
		int value = Integer.parseInt(line);
		System.out.println("value : "+line);
		System.out.println("Change value : "+(value+10));
		
}
}
