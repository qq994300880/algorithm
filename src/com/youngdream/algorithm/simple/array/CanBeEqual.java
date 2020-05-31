package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/31 22:24
 */
public class CanBeEqual {
    /**
     * 给你两个长度相同的整数数组 target 和 arr 。
     * 每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
     * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
     * <p>
     * 示例 1：
     * 输入：target = [1,2,3,4], arr = [2,4,1,3]
     * 输出：true
     * 解释：你可以按照如下步骤使 arr 变成 target：
     * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
     * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
     * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
     * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
     * <p>
     * 示例 2：
     * 输入：target = [7], arr = [7]
     * 输出：true
     * 解释：arr 不需要做任何翻转已经与 target 相等。
     * <p>
     * 示例 3：
     * 输入：target = [1,12], arr = [12,1]
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：target = [3,7,9], arr = [3,7,11]
     * 输出：false
     * 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
     * <p>
     * 示例 5：
     * 输入：target = [1,1,1,1,1], arr = [1,1,1,1,1]
     * 输出：true
     * <p>
     * 提示：
     * target.length == arr.length
     * 1 <= target.length <= 1000
     * 1 <= target[i] <= 1000
     * 1 <= arr[i] <= 1000
     *
     * @param target 目标数组
     * @param arr    给定数组
     * @return 是否能够转换
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[10001];
        for (int i = 0; i < target.length; i++) {
            counts[target[i]]++;
            counts[arr[i]]--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
