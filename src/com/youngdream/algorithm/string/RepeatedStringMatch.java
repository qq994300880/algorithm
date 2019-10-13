package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/10/13 14:31
 */
public class RepeatedStringMatch {
    /**
     * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
     * <p>
     * 举个例子，A = "abcd"，B = "cdabcdab"。
     * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     * <p>
     * 注意:
     *  A 与 B 字符串的长度在1和10000区间范围内。
     */
    //暴力执法
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        while (sb.length() < 2 * A.length() + B.length()) {
            if (sb.indexOf(B) == -1) {
                sb.append(A);
                count++;
            } else return count;
        }
        return -1;
    }

    //最快，lastIndexOf()效率远高于indexOf()
    public int repeatedStringMatch2(String A, String B) {
        int times = (B.length() - 1) / A.length() + 1;//减1是处理刚好B是A的两倍的情况
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(A);
        }
        if (sb.lastIndexOf(B) > -1) return times;
        sb.append(A);
        if (sb.lastIndexOf(B) > -1) return times + 1;
        return -1;
    }
}
