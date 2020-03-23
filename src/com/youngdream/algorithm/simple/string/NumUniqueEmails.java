package com.youngdream.algorithm.simple.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2020/1/2 22:29
 */
public class NumUniqueEmails {
    /**
     * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
     * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
     * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
     * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
     * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
     * 可以同时使用这两个规则。
     * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
     * <p>
     * 示例：
     * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * 输出：2
     * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
     * <p>
     * 提示：
     * 1 <= emails[i].length <= 100
     * 1 <= emails.length <= 100
     * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
     */
    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            char[] chars = email.toCharArray();
            StringBuilder sb = new StringBuilder();
            int middle = email.indexOf('@');
            for (int i = 0; i < middle; i++) {
                char c = chars[i];
                if (c == '.') {
                    continue;
                }
                if (c == '+') {
                    break;
                }
                if (chars[i] == '@') {
                    middle = i;
                    break;
                }
                sb.append(c);
            }
            sb.append(email.substring(middle, chars.length - 1));
            set.add(sb.toString());
        }
        return set.size();
    }

    //最快解
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            set.add(replaceString(s));
        }
        return set.size();
    }

    private String replaceString(String s) {
        char[] chars = s.toCharArray();
        int atIndex = s.indexOf('@');
        StringBuilder builder = new StringBuilder();
        builder.append(chars, atIndex, chars.length - atIndex);
        int offset = 0;
        int length = 0;
        int start = 0;
        for (int i = 0; i < atIndex; i++) {
            if (chars[i] == '.') {
                builder.insert(offset, chars, start, length);
                start = i + 1;
                offset = offset + length;
                length = 0;
            } else if (chars[i] == '+') {
                if (length > 0) {
                    builder.insert(offset, chars, start, length);
                    length = 0;
                }
                break;
            } else {
                length++;
            }
        }
        if (length > 0) {
            builder.insert(offset, chars, start, length);
        }
        return builder.toString();
    }
}
