package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/9/7 15:38
 */
public class DetectCapitalUse {
    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     * <p>
     * 示例 1:
     * 输入: "USA"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "FlaG"
     * 输出: False
     * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
     */
    //通过两个boolean值进行判断  2-3ms   空间O(1)  时间O(n)
    public boolean detectCapitalUse1(String word) {
        boolean begin = false;
        boolean sec = false;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //判断第一个字母
            if (i == 0) {
                //开头为小写
                if (chars[0] > 95) begin = true;
            } else if (i == 1) {
                if (begin) {
                    //如果首字母为小写，第二个字母为大写，返回false
                    if (chars[1] < 95) return false;
                } else if (chars[1] > 95) {
                    //首字母大写，第二个字母小写则sec=true
                    sec = true;
                }
            } else {
                if (begin) {
                    //首位小写，如果后面字符为大写，则返回false
                    if (chars[i] < 95) return false;
                } else if (sec) {
                    //首位大写，第二为小写，如果后面字符为大写，则返回false
                    if (chars[i] < 95) return false;
                } else {
                    //首位大写，第二位大写，如果后面字符为小写，则返回false
                    if (chars[i] > 95) return false;
                }
            }
        }
        return true;
    }

    //通过正则表达式判断 20-23ms
    public boolean detectCapitalUse2(String word) {
        return word.matches("([a-z]+|[A-Z]+|[A-Z][a-z]+)");
    }
}
