package com.youngdream.algorithm.simple.test;

/**
 * @Author YoungDream
 * @Date 2020/1/1 23:42
 */
public class StringPassingMethod {

    private static String s = "aaa";

    public static void main(String[] args) {
        new StringPassingMethod().change(s);
        System.out.println(s);
    }

    private void change(String s) {
//        s = "bbb";
        String replace = s.replace('a', 'b');
        System.out.println(replace);
        System.out.println(StringPassingMethod.s.hashCode());
        System.out.println(s.hashCode());
        System.out.println(StringPassingMethod.s.equals(s));
    }
}
