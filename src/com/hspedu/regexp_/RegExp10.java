package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp10 {
    public static void main(String[] args) {
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&vd_source=67b20ddcf1eeb286852b980c537cea4d";
        // String regStr = "^[\u0391-\uffe5]+$";  //验证汉字
        // String regStr = "^[1-9]\\d{5}";  // 验证邮编

        // String regStr = "^[1-9]\\d{4,9}$";  // 验证qq号码

        // 在中括号[]里写./? 就是代表它们本身
        String regStr = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
