package com.demo.test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;

public class TestEmoji {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String emostring ="😂😍🎉👍";
		System.out.println("length : "+emostring.length());
		String sb=new StringBuilder().appendCodePoint(
				emostring.codePointAt(emostring.offsetByCodePoints(0, 1))).toString();
		System.out.println(sb);
	}

}
