package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/11/27 17:33
 */
public class RotateString {
    /**
     * 给定两个字符串, A 和 B。
     * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
     * <p>
     * 示例 1:
     * 输入: A = 'abcde', B = 'cdeab'
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: A = 'abcde', B = 'abced'
     * 输出: false
     * <p>
     * 注意：
     * A 和 B 长度不超过 100。
     */
    public boolean rotateString(String A, String B) {
        /*
        思路：     A='abcde...z'
        旋转1次 => bcde...za
        旋转2次 => cde...zab
        旋转3次 => de...zabc
            .
            .
            .
        旋转A.length()-1次 => zabcde...

        A+A => abcde...zabcde...z  包含以上所有情况
        因此只需要判断 A+A是否包含B 就可以了
         */
        if (A.length() != B.length()) return false;
        return (A + A).contains(B);
    }
}
