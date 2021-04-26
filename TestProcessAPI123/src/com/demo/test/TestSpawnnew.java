package com.demo.test;

import java.io.IOException;

public class TestSpawnnew {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder p=new ProcessBuilder("notepad.exe");
		Process pchild=p.start();
		System.out.println("Pid "+pchild.toHandle().pid());
		Thread.sleep(100000);
		System.out.println("destroy the processs");
        pchild.destroy();
	}

}
