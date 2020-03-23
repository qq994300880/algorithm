package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/2/23 21:53
 */
public class BalancedStringSplit {
    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量。
     * <p>
     * 示例 1：
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * <p>
     * 示例 2：
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * <p>
     * 示例 3：
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR".
     * <p>
     * 提示：
     * 1 <= s.length <= 1000
     * s[i] = 'L' 或 'R'
     */
    public int balancedStringSplit(String s) {
        int balance = 0;
        int index = 0;
        int result = 0;
        int len = s.length();
        while (index < len) {
            char c = s.charAt(index++);
            if (c == 'L') {
                balance++;
            } else if (c == 'R') {
                balance--;
            }
            if (balance == 0) {
                result++;
            }
        }
        return result;
    }
}
