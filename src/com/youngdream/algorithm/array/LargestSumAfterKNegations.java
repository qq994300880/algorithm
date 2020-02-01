package com.youngdream.algorithm.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/2/1 18:42
 */
public class LargestSumAfterKNegations {
    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
     * 以这种方式修改数组后，返回数组可能的最大和。
     * <p>
     * 示例 1：
     * 输入：A = [4,2,3], K = 1
     * 输出：5
     * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
     * <p>
     * 示例 2：
     * 输入：A = [3,-1,0,2], K = 3
     * 输出：6
     * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
     * <p>
     * 示例 3：
     * 输入：A = [2,-3,-1,5,-4], K = 2
     * 输出：13
     * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
     *  
     * 提示：
     * 1 <= A.length <= 10000
     * 1 <= K <= 10000
     * -100 <= A[i] <= 100
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int len = A.length;
        int sum = 0;
        int index = 0;
        while (K > 0 && A[index] < 0) {
            sum -= A[index++];
            K--;
        }
        if (K != 0 && (K & 1) == 1) {
            if (index == 0) {
                sum -= A[index++];
            } else if (-A[index - 1] > A[index]) {
                sum -= A[index++];
            } else {
                sum += A[index - 1];
                sum += A[index - 1];
            }
        }
        while (index < len) {
            sum += A[index++];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-2, 5, 0, 2, -2};
        int K = 3;
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(A, K));
    }
}
