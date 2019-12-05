package com.youngdream.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/12/6 1:55
 */
public class LargeGroupPositions {
    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 最终结果按照字典顺序输出。
     * <p>
     * 示例 1:
     * 输入: "abbxxxxzzy"
     * 输出: [[3,6]]
     * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * <p>
     * 示例 2:
     * 输入: "abc"
     * 输出: []
     * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
     * <p>
     * 示例 3:
     * 输入: "abcdddeeeeaabbbcd"
     * 输出: [[3,5],[6,9],[12,14]]
     * 说明:  1 <= S.length <= 1000
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        char temp = ' ';
        int count = 1;
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (temp != c) {
                if (count > 2) {
                    result.add(Arrays.asList(start, i - 1));
                }
                temp = c;
                count = 1;
                start = i;
            } else {
                count++;
            }
        }
        if (count > 2) {
            result.add(Arrays.asList(start, chars.length - 1));
        }
        return result;
    }
}
