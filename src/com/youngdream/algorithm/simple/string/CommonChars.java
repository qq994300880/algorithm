package com.youngdream.algorithm.simple.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/1/31 17:38
 */
public class CommonChars {
    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 你可以按任意顺序返回答案。
     * <p>
     * 示例 1：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * <p>
     * 示例 2：
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     * <p>
     * 提示：
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 100
     * A[i][j] 是小写字母
     */
    public List<String> commonChars1(String[] A) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        int[] temp;
        char[] chars = A[0].toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        for (String s : A) {
            chars = s.toCharArray();
            temp = new int[26];
            for (char c : chars) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            int a = count[i];
            for (int j = 0; j < a; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }


    //  优化解
    public List<String> commonChars(String[] strings) {
        List<String> result = new ArrayList<>();
        short[] source = new short[26];
        char[] chars = strings[0].toCharArray();
        for (char c : chars) {
            source[c - 'a']++;
        }
        for (String s : strings) {
            source = merge(source, s);
        }
        for (int i = 0; i < source.length; i++) {
            int count = source[i];
            for (int j = 0; j < count; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }

    private short[] merge(short[] source, String s) {
        short[] temp = new short[26];
        for (char c : s.toCharArray()) {
            temp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] < source[i]) {
                source[i] = temp[i];
            }
        }
        return source;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"bella", "label", "roller"};
        System.out.println(new CommonChars().commonChars(A));
    }
}
