package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2020/1/1 0:32
 */
public class CountAndSay {
    /**
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * <p>
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     * 注意：整数序列中的每一项将表示为一个字符串。
     * <p>
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     * <p>
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     */
    public String countAndSay(int n) {
        return result[n];
    }

    private static String[] result = new String[31];

    static {
        result[1] = "1";
        for (int i = 2; i < result.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = result[i - 1].toCharArray();
            int count = 1;
            char temp = chars[0];
            for (int j = 1; j < chars.length; j++) {
                char c = chars[j];
                if (c != temp) {
                    sb.append(count);
                    count = 1;
                    sb.append(temp);
                    temp = c;
                } else {
                    count++;
                }
            }
            sb.append(count);
            sb.append(temp);
            result[i] = sb.toString();
        }
    }
}
