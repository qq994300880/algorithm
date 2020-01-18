package com.youngdream.algorithm.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YoungDream
 * @date 2020/1/18 23:36
 */
public class AddToArrayForm {
    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     * <p>
     * 示例 1：
     * 输入：A = [1,2,0,0], K = 34
     * 输出：[1,2,3,4]
     * 解释：1200 + 34 = 1234
     * <p>
     * 示例 2：
     * 输入：A = [2,7,4], K = 181
     * 输出：[4,5,5]
     * 解释：274 + 181 = 455
     * <p>
     * 示例 3：
     * 输入：A = [2,1,5], K = 806
     * 输出：[1,0,2,1]
     * 解释：215 + 806 = 1021
     * <p>
     * 示例 4：
     * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
     * 输出：[1,0,0,0,0,0,0,0,0,0,0]
     * 解释：9999999999 + 1 = 10000000000
     * <p>
     * 提示：
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 9
     * 0 <= K <= 10000
     * 如果 A.length > 1，那么 A[0] != 0
     */
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int temp = K;
        int kLength = 0;
        while (temp > 0) {
            temp /= 10;
            kLength++;
        }
        int maxLength = Math.max(A.length, kLength);
        List<Integer> result = new ArrayList<>(maxLength + 1);
        int[] resArray = new int[maxLength];
        maxLength--;
        int a;
        int b;
        int sum;
        boolean carry = false;
        int index = A.length - 1;
        while (index > -1 || K > 0) {
            if (index > -1) {
                a = A[index--];
            } else {
                a = 0;
            }
            b = K % 10;
            K /= 10;
            sum = a + b;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum > 9) {
                carry = true;
                sum %= 10;
            }
            resArray[maxLength--] = sum;
        }
        if (carry) {
            result.add(1);
        }
        for (int i : resArray) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        int value;
        int sum;
        boolean carry = false;
        for (int i = A.length - 1; i >= 0; i--) {
            value = K % 10;
            K /= 10;
            sum = A[i] + value;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum > 9) {
                sum -= 10;
                carry = true;
            }
            result.addFirst(sum);
        }

        while (K > 0) {
            value = K % 10;
            K /= 10;
            if (carry) {
                value++;
                carry = false;
            }
            if (value > 9) {
                value -= 10;
                carry = true;
            }
            result.addFirst(value);
        }
        if (carry) {
            result.addFirst(1);
        }
        return result;
    }
}
