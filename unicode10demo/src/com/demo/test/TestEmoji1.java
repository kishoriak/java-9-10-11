package com.demo.test;

import java.io.UnsupportedEncodingException;

public class TestEmoji1 {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static void main(String[] args) throws UnsupportedEncodingException {


		int[] surrogates = {0xD83D, 0xDC7D};
		String alienEmojiString = new String(surrogates, 0, surrogates.length);
		System.out.println(ANSI_YELLOW+"crazy face"+String.valueOf(alienEmojiString));
		//System.out.println("crazy face"+String.valueOf(alienEmojiString));
		//System.out.println("\uD83D\uDC7D");
		//byte[] b="\uD83D\uDE01".getBytes("UTF-32");
		//System.out.println(b);
		
		String context = "You can eat water too! ";
        context += new String(Character.toChars(0x1F349));
		System.out.println(context);
		String str=new String(Character.toChars(0x1F601));
		System.out.println("smiley:"+str);

		 str=new String(Character.toChars(0x1F60E));
		System.out.println("smiley with sunglasses:"+str);

	}

}
