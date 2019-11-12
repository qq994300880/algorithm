package com.youngdream.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2019/11/12 12:44
 */
public class LongestWord {
    /**
     * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
     * 若无答案，则返回空字符串。
     * <p>
     * 示例 1:
     * 输入:
     * words = ["w","wo","wor","worl", "world"]
     * 输出: "world"
     * 解释:
     * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
     * <p>
     * 示例 2:
     * 输入:
     * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
     * 输出: "apple"
     * 解释:
     * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
     * <p>
     * 注意:
     * 所有输入的字符串都只包含小写字母。
     * words数组长度范围为[1,1000]。
     * words[i]的长度范围为[1,30]。
     */
    //1.利用Arrays工具类的排序和HashSet判断
    public String longestWord2(String[] words) {
        Arrays.sort(words);//将单词按自然排序排好
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            //如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;//优先判断的是自然排序靠前的单词
                set.add(s);
            }
        }
        return res;
    }

    //2.前缀树
    private TrieNode root;//前缀树根节点
    private String res;//返回结果
    private String[] words;//提升作用域

    public String longestWord(String[] words) {
        //初始化
        this.root = new TrieNode();
        this.res = "";
        this.words = words;
//        int index = 0;
//        for (String word : words) {
//            root.insert(word, index++);
//        }
        //同上
        for (int i = 0; i < words.length; i++) {
            root.insert(words[i], i);
        }
        dfs(root);
        return res;
    }

    private class TrieNode {
        int index;//记录该单词是否存在，以及在数组中的索引下标
        TrieNode[] children;

        TrieNode() {
            index = -1;
            children = new TrieNode[26];
        }

        //将字符串加入到字典树中
        private void insert(String word, int index) {
            char[] chs = word.toCharArray();
            TrieNode cur = root;
            for (char c : chs) {
                int n = c - 'a';//计算数组索引
                if (cur.children[n] == null) {
                    TrieNode node = new TrieNode();
                    cur.children[n] = node;
                }
                cur = cur.children[n];
            }
            cur.index = index;//记录存在标记以及数组索引下标
        }
    }

    private void dfs(TrieNode ref) {
        if (ref.index != -1) {//针对root区别对待
            String word = words[ref.index];//获取到该单词
            //记录结果，已经排序过，先来先赋值
            if (word.length() > res.length()) {
                res = word;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (ref.children[i] != null && ref.children[i].index != -1) {//如果单词前缀存在则继续查找
                dfs(ref.children[i]);
            }
        }
    }
}
