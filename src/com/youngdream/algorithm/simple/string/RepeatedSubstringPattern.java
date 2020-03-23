package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/8/23 0:53
 */
public class RepeatedSubstringPattern {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */

    //方法一：利用split获取字符串数组，正则匹配，效率低，超时
    public boolean repeatedSubstringPattern1(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length / 2; i++) {
            sb.append(chars[i]);
            String[] split = s.split(sb.toString());
            if (split.length == 0) return true;
        }
        return false;
    }

    //方法二：abc+abc => bc+abc+abc+ab
    public boolean repeatedSubstringPattern2(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 2);
        sb.append(s).append(s).deleteCharAt(0).deleteCharAt(sb.length() - 1);
        return sb.toString().contains(s);
    }

    //方法三：周期串 chars[i % t] == chars[i]
    public boolean repeatedSubstringPattern3(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int i = 0;
        int t = 0;
        for (t = 1; t <= len / 2; t++) {
            //如果有余数一定不是周期串
            if (len % t == 0) {
                i = t;
                while (i < len && chars[i % t] == chars[i]) {
                    i++;
                }
                if (i == len) return true;
            }
        }
        return false;
    }
}
