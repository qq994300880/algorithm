package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/30 21:32
 */
public class ReplaceSpaces {
    /**
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * <p>
     * 示例1:
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * <p>
     * 示例2:
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     * <p>
     * 提示：
     * 字符串长度在[0, 500000]范围内。
     *
     * @param S      给定字符串
     * @param length 真实长度
     * @return URL字符串
     */
    public String replaceSpaces(String S, int length) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            if (S.charAt(i) == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(S.charAt(i));
//            }
//        }
//        return sb.toString();
        int index = S.length();
        char[] chars = S.toCharArray();
        while (length > 0) {
            if (chars[--length] == ' ') {
                chars[--index] = '0';
                chars[--index] = '2';
                chars[--index] = '%';
            } else {
                chars[--index] = chars[length];
            }
        }
        return String.copyValueOf(chars, index, S.length() - index);
    }
}
