package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/4/1 21:55
 */
public class CompressString {
    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * <p>
     * 示例1:
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 示例2:
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     *
     * @param S 给定字符串
     * @return 压缩后的字符串
     */
    public String compressString(String S) {
        if (S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char temp = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == temp) {
                count++;
            } else {
                sb.append(temp);
                sb.append(count);
                temp = S.charAt(i);
                count = 1;
            }
        }
        sb.append(temp);
        sb.append(count);
        if (sb.length() < S.length()) {
            return sb.toString();
        }
        return S;
    }
}
