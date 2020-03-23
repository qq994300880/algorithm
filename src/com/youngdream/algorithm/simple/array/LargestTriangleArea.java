package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/1 22:34
 */
public class LargestTriangleArea {
    /**
     * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
     * <p>
     * 示例:
     * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
     * 输出: 2
     * 解释:
     * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
     * <p>
     * 注意:
     * 3 <= points.length <= 50.
     * 不存在重复的点。
     *  -50 <= points[i][j] <= 50.
     * 结果误差值在 10^-6 以内都认为是正确答案。
     */
    public double largestTriangleArea1(int[][] points) {
        double result = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = i + 2; k < points.length; k++) {
                    result = Math.max(result, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return result;
    }

    //  海伦公式
    private double getArea(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1]
                - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }

    //  通过斜率求面积(排除斜率不存在)效率低下
    private double getArea1(int[] point1, int[] point2, int[] point3) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        int x3 = point3[0];
        int y3 = point3[1];
        double bottom = 0;
        double height = 0;
        //  斜率不存在
        if (x1 == x2) {
            bottom = Math.abs(y1 - y2);
            height = Math.abs(x3 - x1);
        } else if (y1 == y2) {
            bottom = Math.abs(x1 - x2);
            height = Math.abs(y3 - y1);
        } else {
            //  勾股定理求第三边(底)
            double a = Math.abs(x1 - x2);
            double b = Math.abs(y1 - y2);
            bottom = Math.sqrt(a * a + b * b);
            //  Ax+By+C=0
            //  k = (y1 - y2) / (x1 - x2) = - A/B
            //  令 A=y1-y2  B=-(x1-x2)
            int A = y1 - y2;
            int B = x2 - x1;
            int C = -(A * x1 + B * y1);
            // 根据点到直线公式计算出高
            height = Math.abs(A * x3 + B * y3 + C) / Math.sqrt(A * A + B * B);
        }
        return bottom * height / 2;
    }

    //  leedcode最优解
    private int[][] mps;

    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        mps = points;
        double max = 0;
        double temp;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j + 1; k < len; ++k) {
                    temp = getArea(i, j, k);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    private double getArea(int i, int j, int k) {
        return Math.abs((mps[i][0] * mps[j][1] + mps[j][0] * mps[k][1] + mps[k][0] * mps[i][1] - mps[i][0] * mps[k][1]
                - mps[j][0] * mps[i][1] - mps[k][0] * mps[j][1]) * 0.5);
    }
}
