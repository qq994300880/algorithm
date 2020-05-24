package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/5/24 22:07
 */
public class IsPrefixOfWord {
    /**
     * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
     * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
     * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
     * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
     * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
     * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
     * <p>
     * 示例 1：
     * 输入：sentence = "i love eating burger", searchWord = "burg"
     * 输出：4
     * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
     * <p>
     * 示例 2：
     * 输入：sentence = "this problem is an easy problem", searchWord = "pro"
     * 输出：2
     * 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
     * <p>
     * 示例 3：
     * 输入：sentence = "i am tired", searchWord = "you"
     * 输出：-1
     * 解释："you" 不是句子中任何单词的前缀。
     * <p>
     * 示例 4：
     * 输入：sentence = "i use triple pillow", searchWord = "pill"
     * 输出：4
     * <p>
     * 示例 5：
     * 输入：sentence = "hello from the other side", searchWord = "they"
     * 输出：-1
     * <p>
     * 提示：
     * 1 <= sentence.length <= 100
     * 1 <= searchWord.length <= 10
     * sentence 由小写英文字母和空格组成。
     * searchWord 由小写英文字母组成。
     * 前缀就是紧密附着于词根的语素，中间不能插入其它成分，并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ）
     *
     * @param sentence   检索的句子
     * @param searchWord 检索词
     * @return 最小的单词下标
     */
    public int isPrefixOfWord2(String sentence, String searchWord) {
        //  排除第一个单词为检索词
        int c = 0;
        int len = searchWord.length();
        while (c < len) {
            if (searchWord.charAt(c) != sentence.charAt(c)) {
                break;
            }
            c++;
        }
        if (c == len) {
            return 1;
        }
        //  检索其他单词是否为检索词为前缀
        int i = sentence.indexOf(" " + searchWord);
        //  没有直接返回-1
        if (i == -1) {
            return -1;
        }
        //  初始值为2(第一个单词没有空格，最后一个单词的空格以计算，所以初始值为2)
        int result = 2;
        for (int j = 0; j < i; j++) {
            if (sentence.charAt(j) == ' ') {
                result++;
            }
        }
        return result;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        //  是否为单词且是否可以检查包含检索词
        boolean isWord = true;
        //  sentence的index
        int i = 0;
        //  当前单词开头的index
        int index = 0;
        //  当前为第几个单词
        int count = 1;
        //  句子的长度
        int len = sentence.length();
        while (i < len) {
            if (isWord) {
                for (int j = 0; j < searchWord.length(); j++) {
                    if (sentence.charAt(index + j) != searchWord.charAt(j)) {
                        //  当前sentence的index
                        i = index + j;
                        //  当前单词不可能包含检索词前缀
                        isWord = false;
                        break;
                    }
                }
                //  包含检索词前缀，则返回当前为第几个单词
                if (isWord) {
                    return count;
                }
            } else {
                //  如果当前字符为空格，则开启下一个单词的判断
                if (sentence.charAt(i) == ' ') {
                    count++;
                    //  更新当前单词的开头index
                    index = i + 1;
                    isWord = true;
                }
                i++;
            }
        }
        return -1;
    }
}
