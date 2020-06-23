package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/6/23 23:19
 */
public class ReverseWords {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * <p>
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * <p>
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * <p>
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * 说明：
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
     * <p>
     * 注意：此题对比原题有改动
     *
     * @param s 给定字符串
     * @return 翻转的字符串
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int[] indexs = new int[1000];
        if (s.charAt(0) != ' ') {
            indexs[count++] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                indexs[count++] = i;
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            indexs[count++] = s.length();
        }
        int pre;
        int now;
        for (int i = count - 1; i > 0; i--) {
            pre = indexs[i - 1];
            now = indexs[i];
            if (now - pre != 1) {
                for (int j = pre + 1; j < now; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String reverseWord3(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isWord = false;
        int start = 0;
        int end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (!isWord) {
                    end = i;
                    isWord = true;
                }
                start = i;
            } else if (isWord) {
                sb.append(s, start, end + 1);
                sb.append(' ');
                isWord = false;
            }
        }
        if (isWord) {
            sb.append(s, start, end + 1);
        }
        return sb.toString().trim();
    }
}
