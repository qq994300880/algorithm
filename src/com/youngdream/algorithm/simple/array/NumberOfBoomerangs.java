package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/8/23 14:00
 */
public class NumberOfBoomerangs {
    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     * <p>
     * 示例:
     * 输入:
     * [[0,0],[1,0],[2,0]]
     * 输出:
     * 2
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     */
    public int numberOfBoomerangs1(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length - 2; i++) {
            //获取第一个点并且不重复
            int[] one = points[i];
            for (int j = i + 1; j < points.length - 1; j++) {
                //获取第二个点
                int[] two = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    //获取第三个点
                    int[] three = points[k];
                    //计算距离的平方
                    int distance1 = (one[0] - two[0]) * (one[0] - two[0]) + (one[1] - two[1]) * (one[1] - two[1]);
                    int distance2 = (two[0] - three[0]) * (two[0] - three[0]) + (two[1] - three[1]) * (two[1] - three[1]);
                    int distance3 = (one[0] - three[0]) * (one[0] - three[0]) + (one[1] - three[1]) * (one[1] - three[1]);
                    if (distance1 == distance2) count += 2;
                    if (distance2 == distance3) count += 2;
                    if (distance1 == distance3) count += 2;
                }
            }
        }
        return count;
    }
}