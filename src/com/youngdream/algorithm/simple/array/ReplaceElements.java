package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/3/5 22:04
 */
public class ReplaceElements {
    /**
     * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     * 完成所有替换操作后，请你返回这个数组。
     * <p>
     * 示例：
     * 输入：arr = [17,18,5,4,6,1]
     * 输出：[18,6,6,6,1,-1]
     * <p>
     * 提示：
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i] <= 10^5
     */
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int start = 0;
        int index = 1;
        int max = 0;
        while (start < len - 1) {
            //  找到后区域最大的数和它的索引
            for (int i = start + 1; i < len; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            //  从修改结束的位置到最大数的索引之前都为记录的最大的数
            for (int i = start; i < index; i++) {
                arr[i] = max;
            }
            //  记录位置
            start = index;
            //  区域最大数重置
            max = 0;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
