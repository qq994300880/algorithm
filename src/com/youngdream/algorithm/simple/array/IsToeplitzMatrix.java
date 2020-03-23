package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @Author YoungDream
 * @Date 2019/11/17 15:46
 */
public class IsToeplitzMatrix {
    /**
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     * <p>
     * 示例 1:
     * 输入:
     * matrix = [
     *   [1,2,3,4],
     *   [5,1,2,3],
     *   [9,5,1,2]
     * ]
     * 输出: True
     * 解释:
     * 在上述矩阵中, 其对角线为:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
     * 各条对角线上的所有元素均相同, 因此答案是True。
     * <p>
     * 示例 2:
     * 输入:
     * matrix = [
     *   [1,2],
     *   [2,2]
     * ]
     * 输出: False
     * 解释:
     * 对角线"[1, 2]"上的元素不同。
     * <p>
     * 说明:
     *  matrix 是一个包含整数的二维数组。
     * matrix 的行数和列数均在 [1, 20]范围内。
     * matrix[i][j] 包含的整数在 [0, 99]范围内。
     * <p>
     * 进阶:
     * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
     * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
     */
    //暴力法，超时
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int hight = matrix.length - 1;
        int width = matrix[0].length - 1;
        int mark;//获取基准值
        //判断横排(排除最后一列)
        for (int j = width - 1; j > 0; j--) {
            int i = 0;
            mark = matrix[i][j];
            while (++i <= hight && ++j < width) {
                if (matrix[i][j] != mark) return false;
            }
        }
        //判断竖排(排除第一排和最后一排)
        for (int i = 1; i < hight; i++) {
            int j = 0;
            mark = matrix[i][j];
            while (++i <= hight && ++j < width) {
                if (matrix[i][j] != mark) return false;
            }
        }
        return true;
    }

    /**
     * 设计单列新矩阵记录
     * [[1,2,3,4],
     * [5,1,2,3],       ==>     [9,5-5,1-1-1,2-2-2,3-3,4]
     * [9,5,1,2]]
     */
    public boolean isToeplitzMatrix2(int[][] matrix) {
        int hight = matrix.length;//3
        int width = matrix[0].length;//4
        int[] newArray = new int[hight + width - 1];//创建新列6
        Arrays.fill(newArray, -1);//填充没有值的字段(初始化数组)
        //遍历矩阵
        for (int i = 0; i < hight; i++) {
            int[] mat = matrix[i];
            for (int j = 0; j < width; j++) {
                int index = hight - 1 - i + j;//计算记录的索引
                if (newArray[index] == -1) newArray[index] = mat[j];//如果没有值则填入
                else if (newArray[index] != mat[j]) return false;//如果值不为-1说明之前有值，判断是否相等即可
            }
        }
        return true;
    }
}
