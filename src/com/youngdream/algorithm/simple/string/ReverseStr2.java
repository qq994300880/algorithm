package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/9/14 19:50
 */
public class ReverseStr2 {
    /**
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     * <p>
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * <p>
     * 要求:
     * 该字符串只包含小写的英文字母。
     * 给定字符串的长度和 k 在[1, 10000]范围内。
     */
    public String reverseStr1(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        while (index < length) {
            //如果长度>=k&&2k< 或者==2k
            int n = k - 1;
            //判断长度
            if (length - index < k) {
                n = length - index - 1;
            }
            for (int i = 0; i < (n + 1) / 2; i++) {
                char temp = chars[index + i];
                chars[index + i] = chars[index + n - i];
                chars[index + n - i] = temp;
            }
            index += 2 * k;
        }
        return new String(chars);
    }

    //
    public String reverseStr2(String s, int k) {
        int len = s.length();
        if (len == 1) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < len) {
            if (i + k >= len) {
                reverse(arr, i, len - 1);
            } else {
                reverse(arr, i, i + k - 1);
            }
            i += 2 * k;
        }
        //reverse(arr,  i,  i+k >= len? len - 1 : i + k);
        return new String(arr);
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

}
