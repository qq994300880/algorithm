package com.youngdream.algorithm.integer;

/**
 * @Author YoungDream
 * @Date 2019/10/4 17:21
 */
public class JudgeSquareSum {
    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * <p>
     * 示例1:
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     * <p>
     * 示例2:
     * 输入: 3
     * 输出: False
     */
    public boolean judgeSquareSum(int c) {
        //双层for循环，超时
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                int ii = i * i;
                int jj = j * j;
                if (ii + jj == c) return true;
                if (jj > c) break;
            }
        }
        return false;
    }

    //勾股定理，超时
    public boolean judgeSquareSum2(int c) {
        double sqrt = Math.sqrt(c);
        for (int i = 0; i <= sqrt; i++) {
            for (int j = 0; j <= sqrt; j++) {
                if (i + j < sqrt || sqrt < Math.abs(i - j)) continue;
                if (i * i + j * j == c) return true;
            }
        }
        return false;
    }

    //双指针
    public boolean judgeSquareSum3(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) return true;
            else if (sum > c) j--;// sum > c : 整数 j 过大，导致 和 大于 整数 c
            else i++;// sum < c : 整数 i 过小，导致 和 小于 整数 c
        }
        return false;
    }

    /**
     * 费马平方和版(官方最优解)
     * 引理1：形如4k+3的自然数不能表示成2个整数的平方和
     * 引理2：正整数n可被表示为两整数平方和的充要条件为n的一切形如4k+3形状的质因子的幂次均为偶数
     * 说 明：引理2 是基于费马平方和的推论
     */
    public boolean judgeSquareSum4(int c) {
        // n % 2^n = n & 2^n-1
        if ((c & 3) == 3) return false;
        for (int i = 2; i * i <= c; i++) {
            // 求c的质因子
            if (c % i != 0)
                continue;
            // 质因子的幂次
            int count = 0;
            while (c % i == 0) {
                count++;
                c /= i;
            }
            // 引理2
            if ((i & 3) == 3 && (count & 1) == 1) return false;
        }
        // 此c非彼c
        return (c & 3) != 3;
    }
}
