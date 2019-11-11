package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/11/11 19:20
 */
public class IsOneBitCharacter {
    /**
     * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
     * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
     * <p>
     * 示例 1:
     * 输入:
     * bits = [1, 0, 0]
     * 输出: True
     * 解释:
     * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
     * <p>
     * 示例 2:
     * 输入:
     * bits = [1, 1, 1, 0]
     * 输出: False
     * 解释:
     * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
     * <p>
     * 注意:
     * 1 <= len(bits) <= 1000.
     * bits[i] 总是0 或 1.
     */
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;//数组长度
        if (length == 1) return true;//由题意可知长度为1必为真
        for (int i = 0; i < length; i++) {
            if (bits[i] == 1) i++;//遇见1跳两位，遇见0单跳
            else if (i == length - 1) return true;//如果能到达最后一个数，则必定是0结尾
        }
        return false;
    }
}
