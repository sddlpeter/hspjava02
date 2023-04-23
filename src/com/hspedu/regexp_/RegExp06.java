package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp06 {
    public static void main(String[] args) {
        String content = "nnhanz";
        //String regStr = "^[0-9]+[a-z]*";

        // String regStr = "^[0-9]+\\-[a-z]+$"; // 必须是以数字开头，以字母结尾的，^表示必须以后面的开头，$表示必须以某个结尾
        String regStr = "han\\B";  // content = "nnhanz"  匹配到了  regStr = "han\\B"  这是一个bug？
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while(matcher.find()) {
            System.out.println("find: " + matcher.group(0));
        }
    }
}
