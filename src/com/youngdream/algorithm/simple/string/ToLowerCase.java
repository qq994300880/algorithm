package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/11/11 18:43
 */
public class ToLowerCase {
    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     * <p>
     * 示例 1：
     * 输入: "Hello"
     * 输出: "hello"
     * <p>
     * 示例 2：
     * 输入: "here"
     * 输出: "here"
     * <p>
     * 示例 3：
     * 输入: "LOVELY"
     * 输出: "lovely"
     */

    //调用String类的实例方法
    public String toLowerCase1(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c > 64 && c < 91) chars[i] = (char) (c + 32);
        }
        return new String(chars);
    }
}
