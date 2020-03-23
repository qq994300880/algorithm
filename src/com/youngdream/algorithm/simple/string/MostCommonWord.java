package com.youngdream.algorithm.simple.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author YoungDream
 * @Date 2019/12/2 23:43
 */
public class MostCommonWord {
    /**
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
     * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     * <p>
     * 示例：
     * <p>
     * 输入:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * 输出: "ball"
     * 解释:
     * "hit" 出现了3次，但它是一个禁用的单词。
     * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
     * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
     * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
     * <p>
     * 说明：
     * 1 <= 段落长度 <= 1000.
     * 1 <= 禁用单词个数 <= 100.
     * 1 <= 禁用单词长度 <= 10.
     * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
     * paragraph 只包含字母、空格和下列标点符号!?',;.
     * 不存在没有连字符或者带有连字符的单词。
     * 单词里只包含字母，不会出现省略号或者其他标点符号。
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        char[] chars = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            //  除字母以外所有的字符可以判定单词结束
            if (c < 65 || c > 132 && c > 90 && c < 97) {
                if (sb.length() > 0) {
                    String s = sb.toString();
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    sb = new StringBuilder();
                }
            } else {
                //大写字母转换
                if (c < 91) {
                    c += 32;
                }
                sb.append(c);
            }
        }
        //  处理最后一个单词
        if (sb.length() > 0) {
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        //  过滤禁用列表
        for (String s : banned) {
            if (map.containsKey(s)) {
                map.put(s, 0);
            }
        }
        //  遍历map获取结果
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > maxCount) {
                result = entry.getKey();
                maxCount = value;
            }
        }
        return result;
    }
}
