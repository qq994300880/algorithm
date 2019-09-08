package com.youngdream.algorithm.integer;

/**
 * @Author YoungDream
 * @Date 2019/9/8 22:05
 */
public class CheckPerfectNumber {
    /**
     * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
     * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
     * <p>
     * 示例：
     * 输入: 28
     * 输出: True
     * 解释: 28 = 1 + 2 + 4 + 7 + 14
     * <p>
     * 提示：
     * 输入的数字 n 不会超过 100,000,000. (1e8)
     */
    //方式一：遍历    超时
    public boolean checkPerfectNumber1(int num) {
        //如果为1,则sum=0
        if (num == 1) return false;
        int sum = 1;
        int temp = 2;
        while (temp < num / 2 + 1) {
            if (num % temp == 0) sum += temp;
            temp++;
        }
        return num == sum;
    }

    //方式二：方式一以num/2+1当界限，我们可以再次将界限缩小
    public boolean checkPerfectNumber2(int num) {
        if (num == 1) return false;
        double sqrt = Math.sqrt(num);//也可以使用牛顿迭代法自己实现
        int temp = 2;
        int sum = 1;
        while (temp < sqrt) {
            if (num % temp == 0) {
                sum += temp + num / temp;
            }
            temp++;
        }
        return sum == num;
    }

    //方式三：完美数数量有限，条件判断
    public boolean checkPerfectNumber3(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

}
