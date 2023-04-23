package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework02 {
    public static void main(String[] args) {
        String content = "-0.89";
        String regStr = "^[+-]?(0|([1-9])\\d*)(\\.\\d+)?$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
