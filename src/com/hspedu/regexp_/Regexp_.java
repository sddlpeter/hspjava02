package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_ {
    public static void main(String[] args) {
        String content = "网络标志位\t0\t10\t110\t1110\t11110\n" +
                "IP地址范围\t0.0.0.0~127.255.255.255\t128.0.0.0~191.255.255.255\t192.0.0.0~223.255.255.255\t224.0.0.0~239.255.255.255\t240.0.0.0~247.255.255.255\n" +
                "可用IP地址范围\t1.0.0.1~127.255.255.254\t128.0.0.1~191.255.255.254\t192.0.0.1~223.255.255.254\t\t";
        // Pattern pattern = Pattern.compile("[a-zA-Z]+");
        // Pattern pattern = Pattern.compile("[0-9]+");
        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
