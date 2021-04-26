package com.demo.test;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class TestChildrenAndDescendents {
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
	public static void main(String[] args) throws IOException {
		int childProcessCount = 5;
	    for (int i = 0; i < childProcessCount; i++){
	        String javaCmd = getJavaCmd()
	          .getAbsolutePath();
	        ProcessBuilder processBuilder 
	          = new ProcessBuilder(javaCmd, "-version");
	        processBuilder.inheritIO().start();
	    }
	    Stream<ProcessHandle> children
	      = ProcessHandle.current().children();

	    children.filter(ProcessHandle::isAlive)
	      .forEach(ph -> {System.out.format("PID: %d, Cmd: %s",
	        ph.pid(), ph.info().command());
	        System.out.println("-----------------"); });
	    System.out.println("*******************************************************");
	    // and for descendants
	    Stream<ProcessHandle> descendants
	      = ProcessHandle.current().descendants();
	    descendants.filter(ProcessHandle::isAlive)
	      .forEach(ph -> {System.out.format("PID: %d, Cmd: %s",ph.pid(), ph.info().command());
	        System.out.println("-----------------"); });
	}
	

}
