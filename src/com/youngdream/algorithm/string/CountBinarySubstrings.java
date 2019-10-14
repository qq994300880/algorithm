package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/10/14 19:00
 */
public class CountBinarySubstrings {
    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     * <p>
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * <p>
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     * <p>
     * 注意：
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     */
    public int countBinarySubstrings(String s) {
        int[] group = new int[s.length() + 1];//防止数组越界
        char[] chars = s.toCharArray();
        int index = 0;
        int count = 0;
        char temp = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == temp) count++;
            else {
                group[index++] = count;
                count = 1;
                temp = chars[i];
            }
            if (i == chars.length - 1) group[index++] = count;
        }
        int result = 0;
        for (int i = 0; i < index; i++) {
            result += Math.min(group[i], group[i + 1]);//在这里防止数组越界，主要是s.length()==index的情况
        }
        return result;
    }

    //简化以上
    public int countBinarySubstrings2(String s) {
        char[] chars = s.toCharArray();
        //记录之前字符出现的次数
        int last = 0;
        //记录当前字符出现的次数
        int current = 1;
        //记录子串数
        int result = 0;
        //开始计算
        for (int i = 1; i < chars.length; i++) {
            //如果字符相同，则当前字符出现次数加1
            if (chars[i] == chars[i - 1]) current++;
            else {
                //否则取 之前字符次数与当前字符次数 小的
                result += Math.min(last, current);
                //将当前字符出现次数替换之前字符次数
                last = current;
                //重置当前字符次数
                current = 1;
            }
            //对最后一个字符进行统计
            if (i == chars.length - 1) result += Math.min(last, current);
        }
        return result;
    }
}
