package com.demo.test;

public class PrintUnicode {

    public static void main(String[] args) {
    	String a=System.getProperty("file.encoding");
    	System.out.println("encoding: "+a);
        String codepoint = "U+1F92A";   // crazy face
        System.out.println(convertCodePoints(codepoint));
    }

    // Java, UTF-16
    // Convert code point to unicode
    static char[] convertCodePoints(String codePoint) {
        Integer i = Integer.valueOf(codePoint.substring(2), 16);
        char[] chars = Character.toChars(i);
        return chars;

    }

}