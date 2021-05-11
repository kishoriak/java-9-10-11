package com.demo.inicodedata;

import javax.sound.midi.Soundbank;
import java.io.UnsupportedEncodingException;

public class TestEmoji1 {
	public static void main(String[] args)  {
		try {
			int[] surrogates = {0xD83D, 0xDC7D};
			String alienEmojiString = new String(surrogates, 0, surrogates.length);
			System.out.println(String.valueOf(alienEmojiString));
			//System.out.println("\uD83D\uDC7D");
			byte[] b = "\uD83D\uDE01".getBytes("UTF-32");
			System.out.println(b);
			String context = "You can eat water too! ";
			context += new String(Character.toChars(0x1F349));
			System.out.println(context);
		}catch (UnsupportedEncodingException e){
			System.out.println(e.getMessage()+"--->"+e.getCause());
			e.printStackTrace();



		}
	}

}
