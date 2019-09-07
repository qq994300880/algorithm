package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/9/1 16:43
 */
public class LongestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */
    //马拉车，学习一下思路
    public String longestPalindrome1(String s) {
        if (s.length() < 2) return s;
        //预处理
        StringBuilder s1 = new StringBuilder("#");
        char[] chars = s.toCharArray();
        for (char c : chars) {
            s1.append(c);
            s1.append("#");
        }
        //得到的字符串长度永远是奇数,且下标为偶数的都为#
        int len = s1.length();
        int maxRight = 0;                // 当前访问到的所有回文子串，所能触及的最右一个字符的位置
        int pos = 0;                    // MaxRight对应的回文串的对称轴所在的位置
        int maxRL = 0;                    // 最大回文串的回文半径
        int maxPos = 0;                    // MaxRL对应的回文串的对称轴所在的位置
        int[] RL = new int[len];            // RL[i]表示以第i个字符为对称轴的回文串的回文半径
        for (int i = 0; i < len; i++) {
            if (i < maxRight) {
                // 1) 当i在MaxRight的左边
                RL[i] = Math.min(RL[2 * pos - i], maxRight - i);
            } else {
                // 2) 当i在MaxRight的右边
                RL[i] = 1;
            }
            // 尝试扩展RL[i]，注意处理边界
            while (i - RL[i] >= 0  // 可以把RL[i]理解为左半径,即回文串的起始位不能小于0
                    && i + RL[i] < len // 同上,即回文串的结束位不能大于总长
                    && s1.charAt(i - RL[i]) == s1.charAt(i + RL[i])// 回文串特性，左右扩展，判断字符串是否相同
            ) {
                RL[i] += 1;
            }
            // 更新MaxRight, pos
            if (RL[i] + i - 1 > maxRight) {
                maxRight = RL[i] + i - 1;
                pos = i;
            }
            // 更新MaxRL, MaxPos
            if (maxRL <= RL[i]) {
                maxRL = RL[i];
                maxPos = i;
            }
        }
        //同时我们知道字符的RL半径为偶数，#的半径都为奇数,加上之前的下标为偶数的都为#，奇数的都为字符↓
        //得到：
        // # => (maxPos&1)==1  => (maxRL&1)==0
        // 字符 => (maxPos&1)==0  => (maxRL&1)==1
        //
        // 获取开始index
        int start = (maxPos - maxRL + 1) / 2;
        //获取结尾index
        int end = start + maxRL - 1;
        //处理是否包含最后一个字符
        if (end == len) {
            return s.substring(start, end - 1) + s.charAt(s.length() - 1);
        }
        return s.substring(start, end);//注意此处的substring()方法实际上是半开半闭集合 [x,y)，如果包含最后一个字符则需要进行处理
    }

    //基于数组实现
    public String longestPalindrome2(String str) {
        //排除空字符串
        if (str == null || str.length() == 0) return "";
        int len = str.length();
        char[] chars = str.toCharArray();
        //保存起始位置，当前检测的中心点，母串长度
        int[] range = new int[]{0, 0, 0, len};
        for (int i = 0; i < len; i++) {
            range[2] = i;
            i = getMaxLen(chars, range);
        }
        return str.substring(range[0], range[1] + 1);
    }

    public int getMaxLen(char[] chars, int[] range) {
        //中心点的两个下标
        int low = range[2], high = range[2];
        //如果 low = high + 1 位置的字符，则：中心点往后扩一位
        while (high < range[3] - 1 && chars[low] == chars[high + 1]) {
            high++;
        }
        //中心点后移
        range[2] = high;
        //如果 low - 1 = high + 1 位置的字符，则：子串扩张
        while (low > 0 && high < range[3] - 1 && chars[low - 1] == chars[high + 1]) {
            low--;
            high++;
        }
        //更新最大长度位置
        if ((high - low) > (range[1] - range[0])) {
            range[0] = low;
            range[1] = high;
        }
        //返回更新后的中心点
        return range[2];
    }
}
