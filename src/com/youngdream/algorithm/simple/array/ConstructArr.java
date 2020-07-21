package com.youngdream.algorithm.simple.array;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/21 14:37
 */
public class ConstructArr {
    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * <p>
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     * <p>
     * 提示：
     * 所有元素乘积之和不会溢出 32 位整数
     * a.length <= 100000
     *
     * @param a 给定数组a
     * @return 构建的乘积数组
     */
    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        //反向日神仙
        int[] back = new int[len];
        back[len - 1] = 1;
        //重点1️⃣
        for (int i = len - 1; i > 0; i--) {
            back[i - 1] = back[i] * a[i];
        }
        //记录结果
        int[] result = new int[len];
        //前面数的乘积不用统计
        int front = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = front * back[i];
            //重点2️⃣
            front *= a[i];
        }
        return result;
    }

    //更快，明明少用了一个数组统计，但是内存消耗差不多?
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int temp = a[0];
        for (int i = 1; i < a.length; i++) {
            res[i] = temp;
            temp *= a[i];
        }
        temp = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            res[i] *= temp;
            temp *= a[i];
        }
        return res;
    }
}
