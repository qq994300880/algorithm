package com.youngdream.algorithm.simple.string;

import java.util.Arrays;

/**
 * @Author YoungDream
 * @Date 2020/1/4 22:29
 */
public class ReorderLogFiles {
    /**
     * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
     * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
     * 标识符后面的每个字将仅由小写字母组成，或；
     * 标识符后面的每个字将仅由数字组成。
     * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
     * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
     * 返回日志的最终顺序。
     * <p>
     * 示例 ：
     * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
     * <p>
     * 提示：
     * 0 <= logs.length <= 100
     * 3 <= logs[i].length <= 100
     * logs[i] 保证有一个标识符，并且标识符后面有一个字。
     */
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length < 2) {
            return logs;
        }
        int length = logs.length;
        String[] code = new String[length];
        Arrays.fill(code, "");
        int index = 0;
        for (String log : logs) {
            if (Character.isLetter(log.charAt(log.indexOf(' ') + 1))) {
                code[index++] = log;
            }
        }
        Arrays.sort(code);
        for (int i = length - index; i < length; i++) {
            String s = code[i];
            int place = s.indexOf(' ') + 1;
            code[i] = s.substring(place) + "-" + s.substring(0, place);
        }
        Arrays.sort(code);
        int go = 0;
        for (int i = length - index; i < length; i++) {
            String s = code[i];
            int plan = s.indexOf('-') + 1;
            code[go++] = s.substring(plan) + s.substring(0, plan - 1);
        }
        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.indexOf(' ') + 1))) {
                code[index++] = log;
            }
        }
        return code;
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(logs)));
//        String[] temp = new String[4];
//        temp[2] = "b";
//        temp[3] = "a";
//        Arrays.sort(temp);
//        System.out.println(Arrays.toString(temp));
    }
}
