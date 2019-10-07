package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/10/8 1:01
 */
public class ImageSmoother {
    /**
     * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     * <p>
     * 示例 1:
     * 输入:
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * 输出:
     * [[0, 0, 0],
     * [0, 0, 0],
     * [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     * <p>
     * 注意:
     * 给定矩阵中的整数范围为 [0, 255]。
     * 矩阵的长和宽的范围均为 [1, 150]。
     */
    public int[][] imageSmoother(int[][] M) {
        //干扰项排除
        if (M == null) return null;
        int maxHeight = M.length;
        if (maxHeight == 0) return M;
        int maxWidth = M[0].length;
        if (maxHeight < 2 && maxWidth < 2) return M;
        int[][] result = new int[maxHeight][maxWidth];
        //开始替换数值
        //一排
        if (maxHeight == 1) {
            int[] width = M[0];
            for (int i = 0; i < width.length; i++) {
                if (i == 0) {
                    result[0][i] = (width[i] + width[i + 1]) / 2;
                } else if (i == width.length - 1) {
                    result[0][i] = (width[i - 1] + width[i]) / 2;
                } else {
                    result[0][i] = (width[i - 1] + width[i] + width[i + 1]) / 3;
                }
            }
            return result;
        }
        //一竖行
        if (maxWidth == 1) {
            for (int i = 0; i < M.length; i++) {
                if (i == 0) {
                    result[i][0] = (M[i][0] + M[i + 1][0]) / 2;
                } else if (i == M.length - 1) {
                    result[i][0] = (M[i - 1][0] + M[i][0]) / 2;
                } else {
                    result[i][0] = (M[i - 1][0] + M[i][0] + M[i + 1][0]) / 3;
                }
            }
            return result;
        }
        //其他
        //四角计算
        //左上
        result[0][0] += (M[0][0] + M[0][1] + M[1][0] + M[1][1]) / 4;
        //右上
        result[0][maxWidth - 1] = (M[0][maxWidth - 1] + M[0][maxWidth - 2] + M[1][maxWidth - 1] + M[1][maxWidth - 2]) / 4;
        //左下
        result[maxHeight - 1][0] = (M[maxHeight - 1][0] + M[maxHeight - 1][1] + M[maxHeight - 2][0] + M[maxHeight - 2][1]) / 4;
        //右下
        result[maxHeight - 1][maxWidth - 1] = (M[maxHeight - 1][maxWidth - 1] + M[maxHeight - 1][maxWidth - 2] + M[maxHeight - 2][maxWidth - 1] + M[maxHeight - 2][maxWidth - 2]) / 4;
        //边缘计算
        //上下
        for (int i = 1; i < maxWidth - 1; i++) {
            //上
            result[0][i] = (M[0][i] + M[0][i - 1] + M[0][i + 1] + M[1][i] + M[1][i - 1] + M[1][i + 1]) / 6;
            //下
            result[maxHeight - 1][i] = (M[maxHeight - 1][i] + M[maxHeight - 1][i - 1] + M[maxHeight - 1][i + 1] + M[maxHeight - 2][i] + M[maxHeight - 2][i - 1] + M[maxHeight - 2][i + 1]) / 6;
        }
        //左右
        for (int i = 1; i < maxHeight - 1; i++) {
            //左
            result[i][0] = (M[i - 1][0] + M[i][0] + M[i + 1][0] + M[i - 1][1] + M[i][1] + M[i + 1][1]) / 6;
            //右
            result[i][maxWidth - 1] = (M[i - 1][maxWidth - 1] + M[i][maxWidth - 1] + M[i + 1][maxWidth - 1] + M[i - 1][maxWidth - 2] + M[i][maxWidth - 2] + M[i + 1][maxWidth - 2]) / 6;
        }
        //中间正常计算
        for (int i = 1; i < maxHeight - 1; i++) {
            int sum = 0;
            //利用滑动窗口
            for (int j = 1; j < maxWidth - 1; j++) {
                if (j == 1) {
                    sum += M[i - 1][j - 1];
                    sum += M[i - 1][j];
                    sum += M[i - 1][j + 1];
                    sum += M[i][j - 1];
                    sum += M[i][j];
                    sum += M[i][j + 1];
                    sum += M[i + 1][j - 1];
                    sum += M[i + 1][j];
                    sum += M[i + 1][j + 1];
                } else {
                    sum -= M[i - 1][j - 2];
                    sum -= M[i][j - 2];
                    sum -= M[i + 1][j - 2];
                    sum += M[i - 1][j + 1];
                    sum += M[i][j + 1];
                    sum += M[i + 1][j + 1];
                }
                result[i][j] = sum / 9;
            }
        }
        return result;
    }
}
