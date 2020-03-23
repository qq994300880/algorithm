package com.youngdream.algorithm.simple.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/11/25 20:46
 */
public class LetterCasePermutation {
    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * <p>
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     * <p>
     * 输入: S = "12345"
     * 输出: ["12345"]
     * <p>
     * 注意：
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     */
    public List<String> letterCasePermutation(String S) {
        list.clear();//结合实际情况使用clear()，或者新建一个集合
        size = S.length();
        chars = S.toCharArray();
        dfs(0, "");
        return list;
    }

    private int size;
    private List<String> list = new ArrayList<>();
    private char[] chars;

    private void dfs(int index, String string) {
        if (index == size) {
            list.add(string);
            return;
        }
        char c = chars[index++];
        if (64 < c && c < 123) {
            dfs(index, string + c);
            if (c < 91) dfs(index, string + (char) (c + 32));
            if (c > 96) dfs(index, string + (char) (c - 32));
        } else dfs(index, string + c);
    }
}
