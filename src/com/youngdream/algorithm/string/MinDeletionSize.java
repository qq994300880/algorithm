package com.youngdream.algorithm.string;

/**
 * @author YoungDream
 * @date 2020/1/8 23:22
 */
public class MinDeletionSize {
    /**
     * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
     * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
     * 比如，有 A = ["abcdef", "uvwxyz"]，
     * 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
     * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
     * <p>
     * 示例 1：
     * 输入：["cba", "daf", "ghi"]
     * 输出：1
     * 解释：
     * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
     * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
     * <p>
     * 示例 2：
     * 输入：["a", "b"]
     * 输出：0
     * 解释：D = {}
     * <p>
     * 示例 3：
     * 输入：["zyx", "wvu", "tsr"]
     * 输出：3
     * 解释：D = {0, 1, 2}
     * <p>
     * 提示：
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 1000
     */
    public int minDeletionSize1(String[] A) {
        int len = A.length;
        int strLen = A[0].length();
        int result = 0;
        char[][] statistical = new char[len][strLen];
        for (int i = 0; i < len; i++) {
            char[] chars = A[i].toCharArray();
            System.arraycopy(chars, 0, statistical[i], 0, strLen);
        }
        for (int i = 0; i < strLen; i++) {
            for (int j = 1; j < len; j++) {
                if (statistical[j][i] < statistical[j - 1][i]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    //最优解：减少了比较次数
    public int minDeletionSize(String[] A) {
        int len = A[0].length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += isIncreasing(A, i);
        }

        return count;
    }

    private int isIncreasing(String[] A, int idx) {
        char start = A[0].charAt(idx);
        for (int i = 1; i < A.length; i++) {
            if (start > A[i].charAt(idx))
                return 1;
            start = A[i].charAt(idx);
        }
        return 0;
    }
}
