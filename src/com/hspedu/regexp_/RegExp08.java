package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp08 {
    public static void main(String[] args) {
        String content = "Windows 95  Windows 98 Windows NT Windows 2000 Windows XP Windows 7 Windows 11";
        String regStr = "Windows (?=95|98|11)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
