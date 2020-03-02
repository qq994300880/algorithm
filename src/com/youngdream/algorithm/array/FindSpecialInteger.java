package com.youngdream.algorithm.array;

/**
 * @author YangDuan
 * @date 2020/3/2 21:48
 */
public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int count = 0;
        int temp = arr[0];
        for (int i : arr) {
            if (i == temp) {
                count++;
                if (count * 4 > len) {
                    return temp;
                }
            } else {
                temp = i;
                count = 1;
            }
        }
        return temp;
    }
}
