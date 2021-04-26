package com.demo.test;

import java.io.IOException;

public class TestDestroyProcess {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("notepad.exe");
        Process process = builder.start();
        Thread.sleep(10000);
        process.destroy();
        if (process.isAlive()) {
        	System.out.println("in if");
            process.destroyForcibly();
        }
        
        System.out.println("Process destroid? "+process.isAlive());
	}

}
