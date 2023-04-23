package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp09 {
    public static void main(String[] args) {
        String content = "hello11111 ok";
        String regStr = "\\d+?";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
