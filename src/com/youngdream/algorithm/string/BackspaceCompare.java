package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/12/9 23:13
 */
public class BackspaceCompare {
    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * <p>
     * 示例 1：
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * <p>
     * 示例 2：
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * <p>
     * 示例 3：
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * <p>
     * 示例 4：
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     * <p>
     * 提示：
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S 和 T 只含有小写字母以及字符 '#'。
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        char[] chars1 = S.toCharArray();
        char[] chars2 = T.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int delete1 = 0;
        int delete2 = 0;
        for (int i = chars1.length - 1; i >= 0; i--) {
            char s = chars1[i];
            if (s == '#') {
                delete1++;
            } else if (delete1 > 0) {
                delete1--;
            } else {
                sb1.append(s);
            }
        }
        for (int i = chars2.length - 1; i >= 0; i--) {
            char t = chars2[i];
            if (t == '#') {
                delete2++;
            } else if (delete2 > 0) {
                delete2--;
            } else {
                sb2.append(t);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
