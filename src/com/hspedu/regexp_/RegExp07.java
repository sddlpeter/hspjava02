package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp07 {
    public static void main(String[] args) {
        String content = "hanshunping s7789 nn1189han";
        String regStr = "(\\d\\d)(?<grp1>\\d)(\\d)";
        // String regStr = "\\d\\d\\d\\d";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("grp1"));
            System.out.println(matcher.group(3));
        }
    }
}
