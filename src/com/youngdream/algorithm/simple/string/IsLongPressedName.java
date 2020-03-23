package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2020/1/1 23:02
 */
public class IsLongPressedName {
    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * <p>
     * 示例 1：
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     * <p>
     * 示例 2：
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     * <p>
     * 示例 3：
     * 输入：name = "leelee", typed = "lleeelee"
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：name = "laiden", typed = "laiden"
     * 输出：true
     * 解释：长按名字中的字符并不是必要的。
     * <p>
     * 提示：
     * name.length <= 1000
     * typed.length <= 1000
     * name 和 typed 的字符都是小写字母。
     */
    public boolean isLongPressedName(String name, String typed) {
        char[] chars1 = name.toCharArray();
        char[] chars2 = typed.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int length1 = chars1.length;
        int length2 = chars2.length - 1;
        while (index1 < length1) {
            char c1 = chars1[index1];
            if (index2 > length2) {
                return false;
            }
            char c2 = chars2[index2];
            if (c1 == c2) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return true;
    }
}
