package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/10/12 14:50
 */
public class ValidPalindrome2 {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * <p>
     * 示例 1:
     * 输入: "aba"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * <p>
     * 注意:
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     */
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        //前索引
        int start = 0;
        //后索引
        int end = length - 1;
        //要删除的索引
        int deleteIndex = -1;
        while (start < end) {
            //字符不满足回文条件
            if (chars[start] != chars[end]) {
                //如果删除的索引值为字符串长度，则返回false
                if (deleteIndex == length) return false;
                else if (deleteIndex == -1) {//如果还没有要删除的字符，则选择前索引字符删除
                    deleteIndex = start;
                    start++;
                } else {//前索引删除后不满足回文条件，则回到删除前索引状态，选择后索引字符删除
                    start = deleteIndex;
                    end = length - 1 - deleteIndex - 1;
                    deleteIndex = length;
                }
            } else {//前后索引自加自减
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                // 无法确认那个字符是多余的，所有左右都需验证一下
                return validPalindrome(chars, i, j - 1) || validPalindrome(chars, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validPalindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
