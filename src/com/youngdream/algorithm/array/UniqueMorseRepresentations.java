package com.youngdream.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2019/11/28 16:22
 */
public class UniqueMorseRepresentations {
    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
     * 返回我们可以获得所有词不同单词翻译的数量。
     * <p>
     * 例如:
     * 输入: words = ["gin", "zen", "gig", "msg"]
     * 输出: 2
     * <p>
     * 解释:
     * 各单词翻译如下:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     * <p>
     * 共有 2 种不同翻译, "--...-." 和 "--...--.".
     * <p>
     * 注意:
     * 单词列表words 的长度不会超过 100。
     * 每个单词 words[i]的长度范围为 [1, 12]。
     * 每个单词 words[i]只包含小写字母。
     */
    public int uniqueMorseRepresentations(String[] words) {
        //  利用Set特性去重
        Set<String> set = new HashSet<>();
        //  创建密码数组
        String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        //  遍历单词数组
        for (String word : words) {
            //  获取字符数组
            char[] chars = word.toCharArray();
            //  用于拼接字符串
            StringBuilder sb = new StringBuilder();
            //  遍历字符拼接
            for (char c : chars) {
                sb.append(map[c - 'a']);
            }
            //  添加到set集合中去
            set.add(sb.toString());
        }
        //  经过set去重后返回长度大小即可
        return set.size();
    }
}
