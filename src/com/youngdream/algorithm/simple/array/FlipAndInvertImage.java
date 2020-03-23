package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/6 16:35
 */
public class FlipAndInvertImage {
    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     * <p>
     * 示例 1:
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * <p>
     * 示例 2:
     * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * <p>
     * 说明:
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            int length = ints.length;
            for (int i = 0; i < length / 2; i++) {
                int temp = ints[i];
                ints[i] = 1 - ints[length - 1 - i];
                ints[length - 1 - i] = 1 - temp;
//                ints[i] = ints[i] ^ ints[length - 1 - i];
//                ints[length - 1 - i] = ints[i] ^ ints[length - 1 - i];
//                ints[i] = 1 - ints[i] ^ ints[length - 1 - i];
//                ints[length - 1 - i] = 1 - ints[length - 1 - i];
            }
            if ((length & 1) == 1) {
                ints[length / 2] = 1 - ints[length / 2];
            }
        }
        return A;
    }
}
