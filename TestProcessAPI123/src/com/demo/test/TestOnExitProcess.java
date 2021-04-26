package com.demo.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestOnExitProcess {
	public static File getJavaCmd() throws IOException {
        String javaHome = System.getProperty("java.home");
        File javaCmd;
        if (System.getProperty("os.name").startsWith("Win")) {
            javaCmd = new File(javaHome, "bin/java.exe");
        } else {
            javaCmd = new File(javaHome, "bin/java");
        }
        if (javaCmd.canExecute()) {
            return javaCmd;
        } else {
            throw new UnsupportedOperationException(javaCmd.getCanonicalPath() + " is not executable");
        }
    }
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

	    String javaCmd = getJavaCmd().getAbsolutePath();
	    ProcessBuilder processBuilder = new ProcessBuilder(javaCmd, "-version");
	    Process process = processBuilder.inheritIO().start();
	    ProcessHandle processHandle = process.toHandle();

	    System.out.format("PID: %d has started", processHandle.pid());
	    CompletableFuture<ProcessHandle> onProcessExit = processHandle.onExit();
	   // onProcessExit.get(); //blocks till process finishes
	   
	    System.out.println("is alive" +processHandle.isAlive());
	    onProcessExit.thenAccept(ph -> {
	        System.out.format("PID: %d has stopped", ph.pid());
	    });

	}

}
