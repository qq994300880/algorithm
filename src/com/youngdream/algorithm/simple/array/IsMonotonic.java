package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/24 23:32
 */
public class IsMonotonic {
    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * 输入：[1,2,2,3]
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：[6,5,4,4]
     * 输出：true
     * <p>
     * 示例 3：
     * 输入：[1,3,2]
     * 输出：false
     * <p>
     * 示例 4：
     * 输入：[1,2,4,5]
     * 输出：true
     * <p>
     * 示例 5：
     * 输入：[1,1,1]
     * 输出：true
     * <p>
     * 提示：
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     */
    public boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length < 3) {
            return true;
        }
        int temp = A[0];
        int index = 1;
        boolean increase = true;
        while (index < length) {
            int i = A[index];
            if (i > temp) {
                break;
            }
            if (i < temp) {
                increase = false;
                break;
            }
            temp = i;
            index++;
        }
        while (index < length) {
            int i = A[index];
            if (increase) {
                if (i < temp) {
                    return false;
                }
            } else {
                if (i > temp) {
                    return false;
                }
            }
            temp = i;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        new IsMonotonic().isMonotonic(new int[]{1, 3, 2});
    }
}
