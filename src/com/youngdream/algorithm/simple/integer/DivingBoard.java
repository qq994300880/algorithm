package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/8 21:39
 */
public class DivingBoard {
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     * <p>
     * 示例：
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     * <p>
     * 提示：
     * 0 < shorter <= longer
     * 0 <= k <= 100000
     *
     * @param shorter 较短的木板长度
     * @param longer  较长的木板长度
     * @param k       k块木板
     * @return 生成跳板所有的长度
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        int gap = longer - shorter;
        int[] result = new int[k + 1];
        result[0] = k * shorter;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + gap;
        }
        return result;
    }
}
