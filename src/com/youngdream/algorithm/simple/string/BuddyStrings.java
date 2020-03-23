package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/12/12 22:27
 */
public class BuddyStrings {
    /**
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
     * <p>
     * 示例 1：
     * 输入： A = "ab", B = "ba"
     * 输出： true
     * <p>
     * 示例 2：
     * 输入： A = "ab", B = "ab"
     * 输出： false
     * <p>
     * 示例 3:
     * 输入： A = "aa", B = "aa"
     * 输出： true
     * <p>
     * 示例 4：
     * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
     * 输出： true
     * <p>
     * 示例 5：
     * 输入： A = "", B = "aa"
     * 输出： false
     * <p>
     * 提示：
     * 0 <= A.length <= 20000
     * 0 <= B.length <= 20000
     * A 和 B 仅由小写字母构成。
     */
    public boolean buddyStrings1(String A, String B) {
        int aLength = A.length();
        int bLength = B.length();
        if (aLength != bLength || aLength < 2) {
            return false;
        }
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        char aChar = ' ';
        char bChar = ' ';
        int count = 0;
        boolean hasTwo = false;
        int[] nums = new int[26];
        int i = 0;
        while (i < aLength) {
            char a = aChars[i];
            char b = bChars[i];
            if (a != b) {
                if (++count > 2) {
                    return false;
                }
                if (aChar == ' ') {
                    aChar = a;
                    bChar = b;
                } else if (b != aChar || a != bChar) {
                    return false;
                }
            } else {
                if (!hasTwo) {
                    nums[a - 'a'] += 1;
                    if (nums[a - 'a'] > 1) {
                        hasTwo = true;
                    }
                }
            }
            i++;
        }
        if (count == 1) {
            return false;
        }
        if (count == 0) {
            return hasTwo;
        }
        return true;
    }
}
