package com.youngdream.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/2/20 22:07
 */
public class MinimumAbsDifference {
    /**
     * 给你个整数数组 arr，其中每个元素都 不相同。
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     * <p>
     * 示例 1：
     * 输入：arr = [4,2,1,3]
     * 输出：[[1,2],[2,3],[3,4]]
     * <p>
     * 示例 2：
     * 输入：arr = [1,3,6,10,15]
     * 输出：[[1,3]]
     * <p>
     * 示例 3：
     * 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * 输出：[[-14,-10],[19,23],[23,27]]
     * <p>
     * 提示：
     * 2 <= arr.length <= 10^5
     * -10^6 <= arr[i] <= 10^6
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int pre;
        int now;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            pre = arr[i - 1];
            now = arr[i];
            if (now - pre < min) {
                result.clear();
                result.add(new ArrayList<Integer>(Arrays.asList(pre, now)));
                min = now - pre;
            } else if (now - pre == min) {
                result.add(new ArrayList<Integer>(Arrays.asList(pre, now)));
            }
        }
        return result;
    }
}
