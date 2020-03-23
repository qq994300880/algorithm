package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/10/8 0:46
 */
public class JudgeCircle {
    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
     * <p>
     * 示例 1:
     * 输入: "UD"
     * 输出: true
     * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
     * <p>
     * 示例 2:
     * 输入: "LL"
     * 输出: false
     * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
     */
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int[] move = new int[4];
        for (char c : chars) {
            switch (c) {
                case 'U':
                    move[0] += 1;
                    break;
                case 'D':
                    move[1] += 1;
                    break;
                case 'R':
                    move[2] += 1;
                    break;
                case 'L':
                    move[3] += 1;
                    break;
                default:
                    throw new RuntimeException("语句包含未识别方向!");
            }
        }
        return move[0] == move[1] && move[2] == move[3];
    }

    //更方便直观
    public boolean judgeCircle2(String moves) {
        int[] cnt = new int[26];
        for (char c : moves.toCharArray()) {
            cnt[c - 'A']++;
        }
        return cnt['L' - 'A'] == cnt['R' - 'A'] && cnt['U' - 'A'] == cnt['D' - 'A'];
    }
}
