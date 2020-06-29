package com.youngdream.algorithm.simple.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author YangDuan
 * @date 2020/6/29 21:56
 */
public class IsPathCrossing {
    /**
     * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
     * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
     * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
     * <p>
     * 示例 1：
     * 输入：path = "NES"
     * 输出：false
     * 解释：该路径没有在任何位置相交。
     * <p>
     * 示例 2：
     * 输入：path = "NESWW"
     * 输出：true
     * 解释：该路径经过原点两次。
     * <p>
     * 提示：
     * 1 <= path.length <= 10^4
     * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
     *
     * @param path 路径字符串
     * @return 路径是否出现相交
     */
    public boolean isPathCrossing(String path) {
        //记录坐标的map
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        //横坐标
        int x = 0;
        //纵坐标
        int y = 0;
        //长度
        int len = path.length();
        HashSet<Integer> set;
        //将0,0添加进map
        set = new HashSet<>();
        set.add(0);
        map.put(0, set);
        for (int i = 0; i < len; i++) {
            //判断方向修改坐标值
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
            }
            //判断map中是否包含横坐标set
            if (map.containsKey(x)) {
                set = map.get(x);
                //set出现过则说明该坐标重复走过
                if (set.contains(y)) {
                    return true;
                } else {
                    //否则添加进set中
                    set.add(y);
                }
            } else {
                //没有set则新建，再添加到map中
                set = new HashSet<>();
                set.add(y);
                map.put(x, set);
            }
        }
        return false;
    }
}
