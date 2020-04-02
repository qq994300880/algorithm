package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/4/2 21:55
 */
public class IsFlipedString {
    /**
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * <p>
     * 示例1:
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"
     * 输出：True
     * <p>
     * 示例2:
     * 输入：s1 = "aa", "aba"
     * 输出：False
     * <p>
     * 提示：
     * 字符串长度在[0, 100000]范围内。
     * <p>
     * 说明:
     * 你能只调用一次检查子串的方法吗？
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 是否为旋转
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }
}
