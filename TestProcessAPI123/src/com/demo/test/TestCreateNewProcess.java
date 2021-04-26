package com.demo.test;

import java.io.File;
import java.io.IOException;

public class TestCreateNewProcess {
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
		    //String javaCommand=getJavaCmd().getAbsolutePath();
		    //ProcessBuilder processBuilder = new ProcessBuilder(javaCommand, "-version");
		    // inheritIO()Sets the source and destination for subprocess standard I/O to be the same as those of the current Java process.
		    ProcessBuilder processBuilder=new ProcessBuilder("java","-version");
		    Process process=processBuilder.inheritIO().start();
		    //to Handle command returns process handle for spawned process
		    ProcessHandle ph=process.toHandle();

	}

}
