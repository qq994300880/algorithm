package com.youngdream.algorithm.array;

/**
 * @author YoungDream
 * @date 2020/1/18 1:00
 */
public class SumEvenAfterQueries {
    /**
     * 给出一个整数数组 A 和一个查询数组 queries。
     * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
     * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
     * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
     * <p>
     * 示例：
     * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
     * 输出：[8,6,2,4]
     * 解释：
     * 开始时，数组为 [1,2,3,4]。
     * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
     * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
     * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
     * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
     * <p>
     * 提示：
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * 1 <= queries.length <= 10000
     * -10000 <= queries[i][0] <= 10000
     * 0 <= queries[i][1] < A.length
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int sum = 0;
        int[] query;
        int num;
        for (int i : A) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            query = queries[i];
            num = A[query[1]];
            if ((num & 1) == 0) {
                sum -= num;
            }
            num += query[0];
            if ((num & 1) == 0) {
                sum += num;
            }
            answer[i] = sum;
            A[query[1]] = num;
        }
        return answer;
    }
}
