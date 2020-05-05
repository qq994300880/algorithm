package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/5 21:36
 */
public class FindString {
    /**
     * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
     * <p>
     * 示例1:
     * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
     * 输出：-1
     * 说明: 不存在返回-1。
     * <p>
     * 示例2:
     * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
     * 输出：4
     * <p>
     * 提示:
     * words的长度在[1, 1000000]之间
     *
     * @param words 字符串数组
     * @param s     给定字符串
     * @return 位置
     */
    public int findString1(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (s.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 排好序，划重点
     *
     * @param words 字符串数组
     * @param s     给定字符串
     * @return 位置
     */
    public int findString(String[] words, String s) {
        //二分？
        int begin = 0;
        int end = words.length - 1;
        while (begin < end) {
            int mid = begin + ((end - begin) >> 1);
            if ("".equals(words[mid])) {
                if (!words[begin].equals(s)) {
                    begin++;
                } else {
                    return begin;
                }
            } else if (words[mid].compareTo(s) < 0) {
                begin = mid + 1;
            } else if (words[mid].compareTo(s) > 0) {
                end = mid - 1;
            } else if (words[mid].equals(s)) {
                return mid;
            }
        }
        return words[begin].equals(s) ? begin : -1;
    }
}
