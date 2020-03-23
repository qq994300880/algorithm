package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2019/9/6 15:22
 */
public class ConvertToBase7 {
    /**
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。
     * <p>
     * 示例 1:
     * 输入: 100
     * 输出: "202"
     * <p>
     * 示例 2:
     * 输入: -7
     * 输出: "-10"
     */
    //短除法后倒转
    public String convertToBase7one(int num) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        }
        while (num > 6) {
            int mod = num % 7;
            builder.append(mod);
            num /= 7;
        }
        if (num > 0) builder.append(num);
        if (neg) builder.append("-");
        return builder.reverse().toString();
    }
}
