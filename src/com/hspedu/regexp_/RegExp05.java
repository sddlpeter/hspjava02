package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
    public static void main(String[] args) {
        String content = "a21111aaa";
        // String regStr = "a{3,4}"; // java 在正则表达式匹配时，默认是贪婪匹配，会尽量匹配多的字符串
        // String regStr = "1{4,5}";
        String regStr = "a1?";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("find: " + matcher.group(0));
        }
    }
}
