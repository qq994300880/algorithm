package com.youngdream.algorithm.simple.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/6/20 21:48
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence2(int target) {
        //滑动窗口
        int start = 1;
        int end = 3;
        int sum = 3;
        int[] temp;
        int half = (target >> 1) + 1;
        List<int[]> counts = new ArrayList<>();
        while (start < half) {
            if (sum < target) {
                sum += end;
                end++;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                temp = new int[end - start];
                for (int i = start; i < end; i++) {
                    temp[i - start] = i;
                }
                counts.add(temp);
                sum -= start;
                start++;
            }
        }
        return counts.toArray(new int[counts.size()][]);
    }

    //速度最快
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        //至少要两个数所以从2开始,target-1
        int number = 2;
        target--;
        //开始的数字
        int start;
        //单个数组的索引
        int index;
        //单个结果
        int[] array;
        while (target > 0) {
            if (target % number == 0) {
                array = new int[number];
                start = target / number;
                index = 0;
                while (start < target / number + number) {
                    array[index] = start;
                    start++;
                    index++;
                }
                result.add(array);
            }
            target -= number++;
        }
        //因为不同序列按首个数字升序排列
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}
