package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/7 21:55
 */
public class FreqAlphabets {
    /**
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
     * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
     * 返回映射之后形成的新字符串。
     * 题目数据保证映射始终唯一。
     * <p>
     * 示例 1：
     * 输入：s = "10#11#12"
     * 输出："jkab"
     * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
     * <p>
     * 示例 2：
     * 输入：s = "1326#"
     * 输出："acz"
     * <p>
     * 示例 3：
     * 输入：s = "25#"
     * 输出："y"
     * <p>
     * 示例 4：
     * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
     * 输出："abcdefghijklmnopqrstuvwxyz"
     * <p>
     * 提示：
     * 1 <= s.length <= 1000
     * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
     * s 是映射始终存在的有效字符串。
     *
     * @param s 编码字符串
     * @return 解码字符串
     */
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        while (index > -1) {
            if (s.charAt(index) == '#') {
                sb.append(chars[Integer.parseInt(String.valueOf(s.charAt(index - 2))) * 10
                        + Integer.parseInt(String.valueOf(s.charAt(index - 1)))]);
                index -= 3;
            } else {
                sb.append(chars[Integer.parseInt("" + s.charAt(index))]);
                index--;
            }
        }
        return sb.reverse().toString();
    }

    private static char[] chars = new char[27];

    static {
        for (int i = 1; i < chars.length; i++) {
            chars[i] = (char) (i + 96);
        }
    }
}