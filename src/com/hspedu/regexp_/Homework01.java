package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework01 {
    public static void main(String[] args) {
        String content = "h_-ello@sohu.mkt.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
