package com.hspedu.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {
        String content = "Java语言是Sun公司于1990年开发的；1994年，Gosling用Java语言开发了一个实用性较高、可靠、安全、有交互功能的新型Web浏览器，它不依赖与任何硬件平台和软件平台，该浏览器被命名为HotJava，并于1995年在业界发表，引起了巨大的轰动，Java语言的地位随之得到了肯定；1995年5月23日，JDK（Java Developmenr Kit）1.0a2版本正是对外发布；2009年4月20日，Sun公司被Oracle公司收购。";
        String regStr = "\\d\\d\\d\\d";

        // 创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建一个匹配器，按照正则表达式规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        // 开始匹配
        while (matcher.find()) {
            System.out.println("找到： " + matcher.group(0));
        }
    }
}
