package com.youngdream.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/8/21 12:50
 */
public class FindDisappearedNumbers {
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     */
    //方法一：使用额外空间 数组进行统计
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int i : nums) {
            count[i] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) res.add(i);
        }
        return res;
    }

    //方法二：不使用额外空间 时间复杂对0(2n)
    private static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            //将数值作为数组下标，将数值存在的数组下标所在数值变为负数
            //例子：
            //{ 4,  3,  2,  7, 8, 2,  3,  1}
            //{-4, -3, -2, -7, 8, 2, -3, -1}
            if (i > 0) {
                if (nums[i - 1] > 0) nums[i - 1] *= -1;
            } else {
                if (nums[-i - 1] > 0) nums[-i - 1] *= -1;
            }
        }
        //取出数组值不为负数的数组下标，+1就为没有出现的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(nums).forEach(System.out::println);
        System.out.println("------------------------------------");
        findDisappearedNumbers2(nums).forEach(System.out::println);
    }
}
