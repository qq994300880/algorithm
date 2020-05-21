package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/5/21 22:02
 */
public class ReplaceSpace {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     * 示例 1：
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * <p>
     * 限制：
     * 0 <= s 的长度 <= 10000
     *
     * @param s 给定字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(String s) {
        char temp;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == ' ') {
                result.append("%20");
            } else {
                result.append(temp);
            }
        }
        return result.toString();
    }
}
