package com.youngdream.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author YoungDream
 * @Date 2019/9/6 15:40
 */
public class FindRelativeRanks {
    /**
     * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
     * (注：分数越高的选手，排名越靠前。)
     * <p>
     * 示例 1:
     * 输入: [5, 4, 3, 2, 1]
     * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
     * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
     * <p>
     * 提示:
     * N 是一个正整数并且不会超过 10000。
     * 所有运动员的成绩都不相同。
     */
    //20ms
    public String[] findRelativeRanks1(int[] nums) {
        String[] result = new String[nums.length];
        //长度为1
        if (nums.length == 1) {
            result[0] = "Gold Medal";
        } else if (nums.length == 2) {
            //长度为2
            if (nums[0] > nums[1]) {
                result[0] = "Gold Medal";
                result[1] = "Silver Medal";
            } else {
                result[0] = "Silver Medal";
                result[1] = "Gold Medal";
            }
        } else {
            //创建数值-索引映射Map
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            //对原数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                //由于升序排序，从最后一个开始
                int index = map.get(nums[nums.length - 1 - i]);
                if (i == 0) {
                    //第一
                    result[index] = "Gold Medal";
                } else if (i == 1) {
                    //第二
                    result[index] = "Silver Medal";
                } else if (i == 2) {
                    //第三
                    result[index] = "Bronze Medal";
                } else {
                    result[index] = i + 1 + "";
                }
            }
        }
        return result;
    }

    //85ms
    public String[] findRelativeRanks2(int[] nums) {
        int length = nums.length;
        String[] result = new String[length];
        //长度大于2
        if (length > 2) {
            //创建一个排序的数组
            int[] temp = new int[length];
            //创建一个记录排名的数组
            int[] sort = new int[length];
            System.arraycopy(nums, 0, temp, 0, length);
            Arrays.sort(temp);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (temp[i] == nums[j]) {
                        sort[j] = length - i;
                        break;
                    }
                }
            }
            for (int i = 0; i < sort.length; i++) {
                int val = sort[i];
                if (val > 3) {
                    result[i] = sort[i] + "";
                } else if (val == 1) {
                    result[i] = "Gold Medal";
                } else if (val == 2) {
                    result[i] = "Silver Medal";
                } else if (val == 3) {
                    result[i] = "Bronze Medal";
                }
            }
        } else if (length == 2) {
            //长度为2
            if (nums[0] > nums[1]) {
                result[0] = "Gold Medal";
                result[1] = "Silver Medal";
            } else {
                result[0] = "Silver Medal";
                result[1] = "Gold Medal";
            }
        } else {
            result[0] = "Gold Medal";
        }
        return result;
    }

    //8ms
    public String[] findRelativeRanks3(int[] nums) {
        //找到最大的值
        int max = -1;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        //创建一个分数对应nums索引的数组
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = i + 1;
        }
        //当前排名
        int rank = 1;
        String[] res = new String[nums.length];
        //从arr数组从后(最高分开始)遍历
        for (int i = arr.length - 1; i >= 0; i--) {
            //获取分数对应nums的索引值+1
            int idx = arr[i];
            //如果idx==0则说明没有对应的分数在nums中
            if (idx > 0) {
                //如果排名第一
                if (rank == 1) res[idx - 1] = "Gold Medal";
                    //第二
                else if (rank == 2) res[idx - 1] = "Silver Medal";
                    //第三
                else if (rank == 3) res[idx - 1] = "Bronze Medal";
                    //其他
                else res[idx - 1] = String.valueOf(rank);
                //当前排名++
                rank++;
            }
        }
        return res;
    }
}
