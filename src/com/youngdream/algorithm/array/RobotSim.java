package com.youngdream.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2019/12/17 22:37
 */
public class RobotSim {
    /**
     * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
     * -2：向左转 90 度
     * -1：向右转 90 度
     * 1 <= x <= 9：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物。
     * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
     * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
     * 返回从原点到机器人的最大欧式距离的平方。
     * <p>
     * 示例 1：
     * 输入: commands = [4,-1,3], obstacles = []
     * 输出: 25
     * 解释: 机器人将会到达 (3, 4)
     * <p>
     * 示例 2：
     * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * 输出: 65
     * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
     * <p>
     * 提示：
     * 0 <= commands.length <= 10000
     * 0 <= obstacles.length <= 10000
     * -30000 <= obstacle[i][0] <= 30000
     * -30000 <= obstacle[i][1] <= 30000
     * 答案保证小于 2 ^ 31
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        //  初始化
        dirction = 1;
        coordinateX = 0;
        coordinateY = 0;
        recordX = new HashMap<>();
        recordY = new HashMap<>();
        //  障碍物记录
        for (int[] obstacle : obstacles) {
            Set<Integer> set = recordX.getOrDefault(obstacle[0], null);
            if (set == null) {
                set = new HashSet<>();
                set.add(obstacle[1]);
                recordX.put(obstacle[0], set);
            } else {
                set.add(obstacle[1]);
            }
            set = recordY.getOrDefault(obstacle[1], null);
            if (set == null) {
                set = new HashSet<>();
                set.add(obstacle[0]);
                recordY.put(obstacle[1], set);
            } else {
                set.add(obstacle[0]);
            }
        }
        for (int command : commands) {
            action(command);
            if (command > 0) {
                result = Math.max(result, coordinateX * coordinateX + coordinateY * coordinateY);
            }
        }
        return result;
    }

    //  方向记录
    //  1:上
    //  2:右
    //  3:下
    //  4:左
    private int dirction;
    //  终点的横坐标
    private int coordinateX;
    //  终点的纵坐标
    private int coordinateY;
    //  障碍物记录
    private Map<Integer, Set<Integer>> recordX;
    private Map<Integer, Set<Integer>> recordY;

    //  行动
    private void action(int command) {
        // 右转
        if (command == -1) {
            dirction++;
            if (dirction > 4) {
                dirction = 1;
            }
            // 左转
        } else if (command == -2) {
            dirction--;
            if (dirction < 1) {
                dirction = 4;
            }
            // 移动
        } else {
            switch (dirction) {
                case 1:
                    moveY(command);
                    break;
                case 3:
                    moveY(-command);
                    break;
                case 2:
                    moveX(command);
                    break;
                case 4:
                    moveX(-command);
                    break;
                default:
            }
        }
    }

    //  移动
    private void moveX(int step) {
        Set<Integer> set = recordY.getOrDefault(coordinateY, null);
        if (set == null) {
            coordinateX += step;
        } else if (step < 0) {
            for (int i = coordinateX - 1; i >= coordinateX + step + 1; i--) {
                if (set.contains(i)) {
                    coordinateX = i + 1;
                    return;
                }
            }
            coordinateX += step;
        } else if (step > 0) {
            for (int i = coordinateX + 1; i <= coordinateX + step; i++) {
                if (set.contains(i)) {
                    coordinateX = i - 1;
                    return;
                }
            }
            coordinateX += step;
        }
    }

    private void moveY(int step) {
        Set<Integer> set = recordX.getOrDefault(coordinateX, null);
        if (set == null) {
            coordinateY += step;
        } else if (step < 0) {
            for (int i = coordinateY - 1; i >= coordinateY + step; i--) {
                if (set.contains(i)) {
                    coordinateY = i + 1;
                    return;
                }
            }
            coordinateY += step;
        } else if (step > 0) {
            for (int i = coordinateY + 1; i <= coordinateY + step; i++) {
                if (set.contains(i)) {
                    coordinateY = i - 1;
                    return;
                }
            }
            coordinateY += step;
        }
    }
}
