package com.youngdream.algorithm.simple.string;

/**
 * @Author YoungDream
 * @Date 2019/10/11 18:36
 */
public class GetHint {
    /**
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     * <p>
     * 示例 1:
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * <p>
     * 示例 2:
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     */
    //空间换时间
    //空间:O(2n+20)
    //时间:O(n+10)
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        //记录数字数量的数组
        int[] counts1 = new int[10];
        int[] counts2 = new int[10];
        char[] chars1 = secret.toCharArray();
        char[] chars2 = guess.toCharArray();
        //计算公牛和记录数字数量
        for (int i = 0; i < chars1.length; i++) {
            //如果位置一样且数字一样则为公牛
            if (chars1[i] == chars2[i]) bulls++;
            else {
                //否则对应的数字数量+1
                counts1[chars1[i] - '0'] += 1;
                counts2[chars2[i] - '0'] += 1;
            }
        }
        //计算母牛个数
        for (int i = 0; i < 10; i++) {
            cows += Math.min(counts1[i], counts2[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
