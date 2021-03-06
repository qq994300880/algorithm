package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/9/7 16:50
 */
public class FindLUSlength {
    /**
     * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
     * <p>
     * 示例 :
     * 输入: "aba", "cdc"
     * 输出: 3
     * 解析: 最长特殊序列可为 "aba" (或 "cdc")
     * <p>
     * 说明:
     * 两个字符串长度均小于100。
     * 字符串中的字符仅含有 'a'~'z'。
     */
    //题目有毒
    public int findLUSlength(String a, String b) {
        //如果长度相等，内容也相同，则没有特殊子序列
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
}
