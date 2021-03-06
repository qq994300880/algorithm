package com.youngdream.algorithm.simple.string;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/2/19 21:38
 */
public class MaxNumberOfBalloons {
    /**
     * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
     * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
     * <p>
     * 示例 1：
     * 输入：text = "nlaebolko"
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：text = "loonbalxballpoon"
     * 输出：2
     * <p>
     * 示例 3：
     * 输入：text = "leetcode"
     * 输出：0
     * <p>
     * 提示：
     * 1 <= text.length <= 10^4
     * text 全部由小写英文字母组成
     */
    public int maxNumberOfBalloons1(String text) {
        int result = Integer.MAX_VALUE;
        int[] letters = new int[26];
        for (char c : text.toCharArray()) {
            letters[c - 97]++;
        }
        letters[11] /= 2;
        letters[14] /= 2;
        for (Integer i : Arrays.asList(0, 1, 11, 13, 14)) {
            if (letters[i] < result) {
                result = letters[i];
            }
        }
        return result;
    }

    //  最优解
    public int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];
        for (char ch : text.toCharArray()) {
            letters[ch - 97]++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 97] < min) {
                min = letters[ch - 97];
            }
        }
        return min;
    }
}
