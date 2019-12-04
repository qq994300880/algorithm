package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/12/4 23:23
 */
public class ToGoatLatin {
    /**
     * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
     * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
     * <p>
     * 山羊拉丁文的规则如下：
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     * <p>
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     * 返回将 S 转换为山羊拉丁文后的句子。
     * <p>
     * 示例 1:
     * 输入: "I speak Goat Latin"
     * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     * <p>
     * 示例 2:
     * 输入: "The quick brown fox jumped over the lazy dog"
     * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     * <p>
     * 说明:
     * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
     * 1 <= S.length <= 150。
     */
    public String toGoatLatin1(String S) {
        StringBuilder sb = new StringBuilder();
        //  正则慢，需要优化
        String[] split = S.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (i != 0) {
                sb.append(' ');
            }
            String s = split[i];
            char c = s.charAt(0);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    sb.append(s);
                    break;
                default:
                    char[] chars = s.toCharArray();
                    for (int j = 1; j < chars.length; j++) {
                        sb.append(chars[j]);
                    }
                    sb.append(chars[0]);
            }
            sb.append('m');
            sb.append('a');
            for (int k = -1; k < i; k++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }

    public String toGoatLatin(String S) {
        //  记录结果
        StringBuilder result = new StringBuilder();
        char[] chars = S.toCharArray();
        //  单词索引
        int count = 1;
        //  是否是单词开头
        boolean start = true;
        //  记录辅音字符索引
        int temp = -1;
        //  遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //  单词开头处理
            if (start) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        //  元音直接添加
                        result.append(c);
                        break;
                    default:
                        //  辅音记录索引即可
                        temp = i;
                }
                //  单词开头置为false
                start = false;
            } else if (c == ' ') { //  单词结束处理
                //  是否以辅音开头
                if (temp != -1) {
                    //  添加辅音字符
                    result.append(chars[temp]);
                    temp = -1;
                }
                result.append('m');
                result.append('a');
                //  添加单词索引个数的 a
                for (int j = 0; j < count; j++) {
                    result.append('a');
                }
                //  单词索引+1
                count++;
                //  添加单词空格
                result.append(' ');
                //  下一个字符是否为单词开头置为true
                start = true;
            } else {
                //  其他单词字符直接添加即可
                result.append(c);
            }
        }
        //  需要对最后一个单词进行额外处理
        if (temp != -1) {
            result.append(chars[temp]);
        }
        result.append('m');
        result.append('a');
        for (int j = 0; j < count; j++) {
            result.append('a');
        }
        return result.toString();
    }
}
