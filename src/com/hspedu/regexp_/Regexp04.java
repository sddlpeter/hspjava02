package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp04 {
    public static void main(String[] args) {
        String content = "hanshunping 韩 寒冷";
        String regStr = "han|韩|寒";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("find: " + matcher.group(0));
        }

    }
}
