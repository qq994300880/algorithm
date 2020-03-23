package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/12/3 23:05
 */
public class ShortestToChar {
    /**
     * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
     * <p>
     * 示例 1:
     * 输入: S = "loveleetcode", C = 'e'
     * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     * <p>
     * 说明:
     * 字符串 S 的长度范围为 [1, 10000]。
     * C 是一个单字符，且保证是字符串 S 里的字符。
     * S 和 C 中的所有字母均为小写字母。
     */
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int start = S.indexOf(C);
        int end = S.lastIndexOf(C);
        //  处理开头
        for (int i = 0; i < start; i++) {
            result[i] = start - i;
        }
        //  处理结尾
        for (int i = result.length - 1; i > end; i--) {
            result[i] = i - end;
        }
        //  处理中间
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = start + 1; i < end; i++) {
            if (chars[i] != C) {
                result[i] = ++count;
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int i = end - 1; i > start; i--) {
            if (chars[i] != C) {
                if (++count < result[i]) {
                    result[i] = count;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }
}