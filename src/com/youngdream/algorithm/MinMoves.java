package com.youngdream.algorithm;

/**
 * @Author YoungDream
 * @Date 2019/8/24 14:53
 */
public class MinMoves {
    /**
     * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
     * <p>
     * 示例:
     * 输入:
     * [1,2,3]
     * 输出:
     * 3
     * 解释:
     * 只需要3次移动（注意每次移动会增加两个元素的值）：
     * <p>
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     */
    //打印
    public int minMovesPrint1(int[] nums) {
        int cishu = nums.length - 1;
        int count = 0;
        int length = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) max = i;
        }
        //检验全等
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) break;
            if (i == cishu) return 0;
        }
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println("]");
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < max) {
                    nums[i] += 1;
                    length++;
                }
                if (length == cishu) break;
            }
            if (length == cishu) {
                System.out.print("[");
                for (int i : nums) {
                    System.out.print(i + ",");
                }
                System.out.println("]");
            }
            if (length != cishu) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == max) {
                        nums[i] += 1;
                        max = nums[i];
                        length++;
                        if (length == cishu) break;
                    }
                }
                System.out.print("[");
                for (int i : nums) {
                    System.out.print(i + ",");
                }
                System.out.println("]");
            }
            length = 0;
            count++;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != max) break;
                if (i == cishu && nums[i] == max) return count;
            }
        }
    }

    //方法一：暴力法，按题介绍解题
    public int minMoves1(int[] nums) {
        int cishu = nums.length - 1;
        int count = 0;
        int length = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) max = i;
        }
        //检验全等
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) break;
            if (i == cishu) return 0;
        }
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < max) {
                    nums[i] += 1;
                    length++;
                }
                if (length == cishu) break;
            }
            if (length != cishu) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == max) {
                        nums[i] += 1;
                        max = nums[i];
                        length++;
                        if (length == cishu) break;
                    }
                }
            }
            length = 0;
            count++;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != max) break;
                if (i == cishu && nums[i] == max) return count;
            }
        }
    }

    //方法二：数学法 n-1个数+1 => 1个数-1  可能出现溢出情况
    public int minMove2(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        //找到最小的数
        for (int i : nums) {
            sum += i;//如果第一个数为Integer.MAX_VALUE，溢出
            if (i < min) min = i;
        }
        return sum - min * nums.length;
    }

    //方法三：数学改进法
    public int minMove3(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        //找到最小的数
        for (int i : nums) {
            if (i < min) min = i;
        }
        //计算和
        for (int i : nums) {
            sum += i - min;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(new MinMoves().minMovesPrint1(nums));
    }
}
