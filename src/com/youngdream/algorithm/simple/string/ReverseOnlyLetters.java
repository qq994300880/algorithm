package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/12/29 22:32
 */
public class ReverseOnlyLetters {
    /**
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * <p>
     * 示例 1：
     * 输入："ab-cd"
     * 输出："dc-ba"
     * <p>
     * 示例 2：
     * 输入："a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     * <p>
     * 示例 3：
     * 输入："Test1ng-Leet=code-Q!"
     * 输出："Qedo1ct-eeLg=ntse-T!"
     * <p>
     * 提示：
     * S.length <= 100
     * 33 <= S[i].ASCIIcode <= 122 
     * S 中不包含 \ or "
     */
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        //  双指针
        while (start < end) {
            char s = chars[start];
            char e = chars[end];
            boolean sIs = Character.isLetter(s);
            boolean eIs = Character.isLetter(e);
            if (sIs && eIs) {
                chars[start] = e;
                chars[end] = s;
                end--;
                start++;
            } else if (sIs) {
                end--;
            } else if (eIs) {
                start++;
            } else {
                end--;
                start++;
            }
        }
        return new String(chars);
    }
}
