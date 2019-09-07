package com.youngdream.algorithm.string;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class CountTheNumbersOfWrods {
    private static int countSegments(String s) {
        if (null == s || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        //连续的不是空格的字符
        int start = 0;
        int end = chars.length - 1;
        int result = 0;
        boolean isSpace = true;
        //去除前后空格
        while (true) {
            if (start < end && chars[start] == 32) {
                start++;
            } else {
                if (end > 0 && chars[end] == 32) {
                    end--;
                } else break;
            }
        }
        //说明全空格
        if (start > end) return 0;
        //计算单词数
        for (int i = start; i < end + 1; i++) {
            if (chars[i] != 32) {
                if (isSpace) {
                    result++;
                    isSpace = false;
                }
            } else isSpace = true;
        }
        return result;
    }
}
