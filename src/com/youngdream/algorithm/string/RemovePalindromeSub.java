package com.youngdream.algorithm.string;

/**
 * @author YangDuan
 * @date 2020/3/12 21:41
 */
public class RemovePalindromeSub {
    /**
     * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
     * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
     * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
     * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
     * <p>
     * 示例 1：
     * 输入：s = "ababa"
     * 输出：1
     * 解释：字符串本身就是回文序列，只需要删除一次。
     * <p>
     * 示例 2：
     * 输入：s = "abb"
     * 输出：2
     * 解释："abb" -> "bb" -> "".
     * 先删除回文子序列 "a"，然后再删除 "bb"。
     * <p>
     * 示例 3：
     * 输入：s = "baabb"
     * 输出：2
     * 解释："baabb" -> "b" -> "".
     * 先删除回文子序列 "baab"，然后再删除 "b"。
     * <p>
     * 示例 4：
     * 输入：s = ""
     * 输出：0
     * <p>
     * 提示：
     * 0 <= s.length <= 1000
     * s 仅包含字母 'a'  和 'b'
     *
     * @param s 给定字符串
     * @return 删除的次数
     */
    public int removePalindromeSub(String s) {
        int result = 0;
        if (s.length() == 0) {
            return result;
        }
        temp = s;
        int start = 0;
        int end = s.length() - 1;
        int endSign = end;
        while (start <= end) {
            if (isPalindrome(start, endSign)) {
                start = endSign + 1;
                endSign = end;
                result++;
            } else {
                endSign--;
            }
        }
        //  回文字符串返回
//        return result;
        //  回文子序列返回
        return result > 1 ? 2 : 1;
    }

    private String temp;

    /**
     * 判断范围内字符串是否为回文字符串
     *
     * @param s 开始索引
     * @param e 结束索引
     * @return 是否为回文字符串
     */
    private boolean isPalindrome(int s, int e) {
        while (s < e) {
            if (temp.charAt(s++) != temp.charAt(e--)) {
                return false;
            }
        }
        return true;
    }
}
