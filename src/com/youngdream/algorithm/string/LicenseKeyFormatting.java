package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/9/2 12:05
 */
public class LicenseKeyFormatting {
    /**
     * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     * <p>
     * 示例 1：
     * 输入：S = "5F3Z-2e-9-w", K = 4
     * 输出："5F3Z-2E9W"
     * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     *      注意，两个额外的破折号需要删掉。
     * <p>
     * 示例 2：
     * 输入：S = "2-5g-3-J", K = 2
     * 输出："2-5G-3J"
     * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     * <p>
     * 提示:
     * S 的长度不超过 12,000，K 为正整数
     * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
     * S 非空
     */
    //方法一：基于字符数组实现
    public String licenseKeyFormatting1(String S, int K) {
        //获取原字符数组
        char[] chars = S.toCharArray();
        //创建一个新字符数组用来存储去"-"
        char[] ans = new char[chars.length];
        //记录新数组的长度
        int leng = 0;
        for (char c : chars) {
            //去"-"
            if (c != '-') {
                ans[leng] = c;
                leng++;
            }
        }
        int mod = leng % K;//取开头个数
        int temp = mod;//用来判断开头个数剩余个数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            char c = ans[i];
            //进行小写转大写
            if (96 < c && c < 123) c -= 32;
            //判断开头个数是否剩余
            if (temp != 0) {
                sb.append(c);
                temp--;
            } else {
                // i==0 代表开头个数也为K个,因此不需要加"-"
                // (i-mod)%K 代表已经写入的个数，等于0代表已经写入了K个，则加上"-"
                if (i != 0 && (i - mod) % K == 0) sb.append("-");
                //继续接上当前这个字符
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //方法二：基于String类库 //不推荐
    public String licenseKeyFormatting2(String S, int K) {
        //替换"-",大写
        S = S.replace("-", "");
        S = S.toUpperCase();
        char[] chars = S.toCharArray();
        StringBuilder builder = new StringBuilder();
        int mod = chars.length % K;
        for (int i = 0; i < chars.length; i++) {
            if (i != 0 && (i - mod) % K == 0) builder.append("-");
            //继续接上当前这个字符
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
