package com.demo.test;

import java.nio.charset.StandardCharsets;

public class HelloMandarian {
    public static void printBytes(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            sb.append(String.format("x%02x ", b));
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String str = "你";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        printBytes(bytes);      // xe4 xbd xa0  (3 bytes)

        // decode
        String decodedStr = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(decodedStr);
    }
}
