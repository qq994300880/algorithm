package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/9/21 15:33
 */
public class ReverseWords3 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc" 
     * <p>
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */
    public String reverseWords(String s) {
        //根据空格得到单词数组
        String[] split = s.split(" ");
        //创建保存结果的StringBuilder
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            //得到单词字符数组
            char[] chars = str.toCharArray();
            //反转单词字符数组
            for (int j = chars.length - 1; j >= 0; j--) {
                sb.append(chars[j]);
            }
            //衔接空格
            sb.append(" ");
        }
        //删除最后一个空格返回
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
