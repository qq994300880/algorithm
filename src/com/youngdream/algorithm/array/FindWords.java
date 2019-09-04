package com.youngdream.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/9/4 19:38
 */
public class FindWords {
    /**
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
     * <p>
     * 示例：
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     * <p>
     * 注意：
     * 你可以重复使用键盘上同一字符。
     * 你可以假设输入的字符串将只包含字母。
     */
    //方法一：利用list判断是否存在，不存在跳出循环
    public String[] findWords1(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        ArrayList<Character> list3 = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            list1.add(c);
        }
        for (char c : s2.toCharArray()) {
            list2.add(c);
        }
        for (char c : s3.toCharArray()) {
            list3.add(c);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String s : words) {
            ArrayList<Character> list = null;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (list == null) {
                    if (list1.contains(chars[i])) list = list1;
                    else if (list2.contains(chars[i])) list = list2;
                    else if (list3.contains(chars[i])) list = list3;
                    else break;
                }
                if (!list.contains(chars[i])) break;
                if (i == chars.length - 1) result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }

    //方法二：利用String类的indexOf()方法来判断是否存在
    public String[] findWords2(String[] words) {
        if (words == null) return words;
        List<String> res = new ArrayList<>();
        String[] s = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        for (String word : words) {
            char[] letters = word.toCharArray();
            int line = -1;
            for (int i = 0; i < 3; i++) {
                if (s[i].indexOf(letters[0]) > -1) line = i;
            }
            for (int j = 0; j < letters.length; j++) {
                if (s[line].indexOf(letters[j]) == -1) {
                    break;
                }
                if (j == letters.length - 1) res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}
