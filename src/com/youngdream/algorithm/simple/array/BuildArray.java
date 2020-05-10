package com.youngdream.algorithm.simple.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/5/10 21:53
 */
public class BuildArray {
    /**
     * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
     * 请使用下述操作来构建目标数组 target ：
     * Push：从 list 中读取一个新元素， 并将其推入数组中。
     * Pop：删除数组中的最后一个元素。
     * 如果目标数组构建完成，就停止读取更多元素。
     * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
     * 请返回构建目标数组所用的操作序列。
     * 题目数据保证答案是唯一的。
     * <p>
     * 示例 1：
     * 输入：target = [1,3], n = 3
     * 输出：["Push","Push","Pop","Push"]
     * 解释：
     * 读取 1 并自动推入数组 -> [1]
     * 读取 2 并自动推入数组，然后删除它 -> [1]
     * 读取 3 并自动推入数组 -> [1,3]
     * <p>
     * 示例 2：
     * 输入：target = [1,2,3], n = 3
     * 输出：["Push","Push","Push"]
     * <p>
     * 示例 3：
     * 输入：target = [1,2], n = 4
     * 输出：["Push","Push"]
     * 解释：只需要读取前 2 个数字就可以停止。
     * <p>
     * 示例 4：
     * 输入：target = [2,3,4], n = 4
     * 输出：["Push","Pop","Push","Push","Push"]
     * <p>
     * 提示：
     * 1 <= target.length <= 100
     * 1 <= target[i] <= 100
     * 1 <= n <= 100
     * target 是严格递增的
     *
     * @param target 目标数组
     * @param n      给定整数
     * @return 操作数组
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int start = 1;
        for (int i : target) {
            while (i != start) {
                result.add("Push");
                result.add("Pop");
                start++;
            }
            result.add("Push");
            start++;
        }
        return result;
    }
}
