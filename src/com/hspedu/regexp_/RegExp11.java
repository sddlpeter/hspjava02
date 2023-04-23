package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp11 {
    public static void main(String[] args) {
        String content = "12321-333999111";
        // String regStr = "(\\d)\\1";  // 连续两个相同的数字
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
