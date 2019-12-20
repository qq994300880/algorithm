package com.youngdream.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YoungDream
 * @Date 2019/12/20 23:16
 */
public class UncommonFromSentences {
    /**
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     * 返回所有不常用单词的列表。
     * 您可以按任何顺序返回列表。
     * <p>
     * 示例 1：
     * 输入：A = "this apple is sweet", B = "this apple is sour"
     * 输出：["sweet","sour"]
     * <p>
     * 示例 2：
     * 输入：A = "apple apple", B = "banana"
     * 输出：["banana"]
     * <p>
     * 提示：
     * 0 <= A.length <= 200
     * 0 <= B.length <= 200
     * A 和 B 都只包含空格和小写字母。
     */
    public String[] uncommonFromSentences(String A, String B) {
        //  正则居然这么快，惊呆了!
        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : splitA) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : splitB) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}
