package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/11/18 13:41
 */
public class NumJewelsInStones {
    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * <p>
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * <p>
     * 注意:
     * S 和 J 最多含有50个字母。
     * J 中的字符不重复。
     */
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        char[] chars1 = J.toCharArray();
        char[] chars2 = S.toCharArray();
//        Set<Character> set = new HashSet<>();
//        for (char c : chars1) {
//            set.add(c);
//        }
//        for (char c : chars2) {
//            if (set.contains(c)) result++;
//        }
        for (char c2 : chars2) {
            for (char c1 : chars1) {
                if (c1 == c2) result++;
            }
        }
        return result;
    }
}
