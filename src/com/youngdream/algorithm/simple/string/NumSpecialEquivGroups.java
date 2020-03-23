package com.youngdream.algorithm.simple.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2019/12/23 22:47
 */
public class NumSpecialEquivGroups {
    /**
     * 你将得到一个字符串数组 A。
     * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
     * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
     * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
     * 返回 A 中特殊等价字符串组的数量。
     * <p>
     * 示例 1：
     * 输入：["a","b","c","a","c","c"]
     * 输出：3
     * 解释：3 组 ["a","a"]，["b"]，["c","c","c"]
     * <p>
     * 示例 2：
     * 输入：["aa","bb","ab","ba"]
     * 输出：4
     * 解释：4 组 ["aa"]，["bb"]，["ab"]，["ba"]
     * <p>
     * 示例 3：
     * 输入：["abc","acb","bac","bca","cab","cba"]
     * 输出：3
     * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
     * <p>
     * 示例 4：
     * 输入：["abcd","cdab","adcb","cbad"]
     * 输出：1
     * 解释：1 组 ["abcd","cdab","adcb","cbad"]
     * <p>
     * 提示：
     * 1 <= A.length <= 1000
     * 1 <= A[i].length <= 20
     * 所有 A[i] 都具有相同的长度。
     * 所有 A[i] 都只由小写字母组成。
     */
    //  官方题解
    public int numSpecialEquivGroups1(String[] A) {
        Set<String> seen = new HashSet<>();
        for (String S : A) {
            int[] count = new int[52];
            char[] chars = S.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                count[chars[i] - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    public int numSpecialEquivGroups2(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            char[] chars = str.toCharArray();
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                //如果是奇数位
                if ((i & 1) == 1) {
                    odd.append(chars[i]);
                } else {
                    //如果为偶数位
                    even.append(chars[i]);
                }
            }
            //排序后拼接
            char[] oddArr = odd.toString().toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toString().toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }
        return set.size();
    }


    //  被质数大军的HashCode给震撼了!!!
    private final static int[] RECORD = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public int numSpecialEquivGroups(String[] A) {
        HashSet<Integer> res = new HashSet<>();
        for (String s : A) {
            res.add(hash(s));
        }
        return res.size();
    }

    private static int hash(String str) {
        int res = 1;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i++) - 97;
            res *= RECORD[idx];
        }
        res += 5000;
        for (int i = 1; i < str.length(); i++) {
            int idx = str.charAt(i++) - 97;
            res *= RECORD[idx];
        }
        return res;
    }
}
