package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/2/13 15:24
 */
public class CountCharacters {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * <p>
     * 示例 1：
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * <p>
     * 示例 2：
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     * <p>
     * 提示：
     * 1 <= words.length <= 1000
     * 1 <= words[i].length, chars.length <= 100
     * 所有字符串中都仅包含小写英文字母
     */
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        int len = chars.length();
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[chars.charAt(i) - 'a']++;
        }
        for (String word : words) {
            if (isTrue(word, count)) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean isTrue(String s, int[] count) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == temp[c - 'a']) {
                return false;
            }
            temp[c - 'a']++;
        }
        return true;
    }
}
