package com.hspedu.regexp_;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
    public static void main(String[] args) {
        String content = "a11c8abca@\n#   $%^Bcefg";
        // String regStr = "[a-z]";
        // String regStr = "[A-Z]";
        String regStr = "."; // 匹配后面的字符串，不区分大小写

        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
