package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp12 {
    public static void main(String[] args) {
        String content = "我...我要...学学学学...编程java!";

        String regStr = "[.]{3}";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        String s = matcher.replaceAll("");
        System.out.println(s);

        //我我要学学学学编程java!

        String ss = "(.)\\1*";
        Pattern compile1 = Pattern.compile(ss);
        Matcher matcher1 = compile1.matcher(s);

        String res = "";

        while (matcher1.find()) {
            res = res + matcher1.group(0).substring(0,1);
        }

        System.out.println(res);


    }
}
