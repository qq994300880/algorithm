package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/23 21:50
 */
public class ReverseBits {
    /**
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
     * <p>
     * 示例 1：
     * 输入: num = 1775(110111011112)
     * 输出: 8
     * <p>
     * 示例 2：
     * 输入: num = 7(01112)
     * 输出: 4
     *
     * @param num 给定数字
     * @return 翻转后的数
     */
    public int reverseBits(int num) {
//        int temp = num;
//        int count = 1;
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        while (temp > 0) {
//            if ((temp & 1) == 0) {
//                list.add(count);
//            }
//            count++;
//            temp >>= 1;
//        }
//        list.add(count);
//        int size = list.size();
//        if (size < 3) {
//            return Integer.bitCount(num) + 1;
//        }
//        count = -1;
//        for (int i = 0; i < size - 2; i++) {
//            count = Math.max(count, list.get(i + 2) - list.get(i) - 1);
//        }
//        return count;

        int temp = num;
        int result = 0;
        int count = 1;
        int one = -1;
        int two = -1;
        int three = 0;
        while (true) {
            if (temp == 0) {
                if (one == -1) {
                    return Integer.bitCount(num) + 1;
                }
                one = two;
                three = count;
                if (one != -1) {
                    result = Math.max(result, three - one - 1);
                }
                break;
            }
            if ((temp & 1) == 0) {
                one = two;
                two = three;
                three = count;
                if (one != -1) {
                    result = Math.max(result, three - one - 1);
                }
            }
            count++;
            temp >>= 1;
        }
        return result;
    }
}
