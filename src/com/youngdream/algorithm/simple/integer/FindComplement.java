package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2019/8/31 11:59
 */
public class FindComplement {
    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * <p>
     * 注意:
     * 给定的整数保证在32位带符号整数的范围内。
     * 你可以假定二进制数不包含前导零位。
     * <p>
     * 示例 1:
     * 输入: 5
     * 输出: 2
     * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
     * <p>
     * 示例 2:
     * 输入: 1
     * 输出: 0
     * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
     */
    //方法一：使用字符串，耗时高，内存消耗大
    public int findComplement1(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') chars[i] = '0';
            else chars[i] = '1';
        }
        return Integer.parseInt(new String(chars), 2);
    }

    //方法二：取反再将之前的0位移除
    public int findComplement2(int num) {
        int index = 0;
        int temp = num;
        int count = 0;
        //计算使用了多少位
        while (temp != 0) {
            index++;
            temp >>= 1;
        }
        //取反
        num = ~num;
        //得到需要左移清空的位数(包括符号位)
        index = 32 - index;
        count = index;
        //清除取非得到的1
        while (index != 0) {
            num <<= 1;
            index--;
        }
        //没有清除的部分还原
        while (count != 0) {
            num >>= 1;
            count--;
        }
        return num;
    }

    //方法三：异或1
    public int findComplement3(int num) {
        int temp = num;
        int yihuo = 0;
        while (temp > 0) {
            temp >>= 1;
            //取得位数的所有1
            yihuo = (yihuo << 1) + 1;
        }
        //返回异或1的结果
        //0b0000....000101 ^ 0b0000....000111 => 0b0000....000010
        return num ^ yihuo;
    }
}
