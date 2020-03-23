package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/2/17 21:04
 */
public class DistanceBetweenBusStops {
    /**
     * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
     * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
     * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
     * <p>
     * 示例 1：
     * <p>
     * 输入：distance = [1,2,3,4], start = 0, destination = 1
     * 输出：1
     * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
     * <p>
     * 示例 2：
     * <p>
     * 输入：distance = [1,2,3,4], start = 0, destination = 2
     * 输出：3
     * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
     * <p>
     * 示例 3：
     * <p>
     * 输入：distance = [1,2,3,4], start = 0, destination = 3
     * 输出：4
     * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
     *  
     * 提示：
     * 1 <= n <= 10^4
     * distance.length == n
     * 0 <= start, destination < n
     * 0 <= distance[i] <= 10^4
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int result = 0;
        for (int i : distance) {
            sum += i;
        }
        if (start > destination) {
            start ^= destination;
            destination ^= start;
            start ^= destination;
        }
        if (destination - start <= distance.length / 2) {
            for (int i = start; i < destination; i++) {
                result += distance[i];
            }
        } else {
            for (int i = 0; i < start; i++) {
                result += distance[i];
            }
            for (int i = destination; i < distance.length; i++) {
                result += distance[i];
            }
        }
        return Math.min(result, sum - result);
    }

    public static void main(String[] args) {
        System.out.println(new DistanceBetweenBusStops().distanceBetweenBusStops(new int[]{37, 24, 13, 6, 39, 30, 5, 36, 19, 38, 37, 8, 17, 24, 51, 2, 25, 38, 19, 28, 37, 6, 35, 16, 21, 24, 29, 24, 49},
                25, 4));
    }
}
