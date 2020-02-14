package com.youngdream.algorithm.string;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/2/14 20:51
 */
public class NumSmallerByFrequency {
    /**
     * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
     * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
     * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
     * <p>
     * 示例 1：
     * 输入：queries = ["cbd"], words = ["zaaaz"]
     * 输出：[1]
     * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
     * <p>
     * 示例 2：
     * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
     * 输出：[1,2]
     * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
     * <p>
     * 提示：
     * 1 <= queries.length <= 2000
     * 1 <= words.length <= 2000
     * 1 <= queries[i].length, words[i].length <= 10
     * queries[i][j], words[i][j] 都是小写英文字母
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] count = new int[words.length];
        int index = 0;
        for (String word : words) {
            count[index++] = getNum(word);
        }
        Arrays.sort(count);
        for (int i = 0; i < result.length; i++) {
            result[i] = calculate(getNum(queries[i]), count);
        }
        return result;
    }

    private int getNum(String s) {
        char c = 'z';
        char now;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (now < c) {
                c = now;
                count = 1;
            } else if (now == c) {
                count++;
            }
        }
        return count;
    }

    private int calculate(int c1, int[] count) {
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] <= c1) {
                return count.length - 1 - i;
            }
        }
        return count.length;
    }
}
