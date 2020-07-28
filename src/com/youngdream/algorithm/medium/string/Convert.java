package com.youngdream.algorithm.medium.string;

/**
 * Z字型变换
 *
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/28 10:49
 */
public class Convert {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * <p>
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * <p>
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * @param s       给定字符串
     * @param numRows 变换的行数
     * @return 变换后的字符串
     */
    public String convert(String s, int numRows) {
        //随风而去
        if (numRows < 2) {
            return s;
        }
        StringBuilder result = new StringBuilder(s.length());
        //字符串长度
        int len = s.length();
        //子串间隔
        int diff = (numRows - 1) << 1;
        //子串字符在字符串中的索引
        int index = 0;
        //对称字符的第几位
        int start = 1;
        //1.添加子串开头
        while (index < len) {
            result.append(s.charAt(index));
            index += diff;
        }
        //2.添加对称字符
        while (start < numRows - 1) {
            //遍历子串
            index = 0;
            while (index < len) {
                //添加对称轴左侧字符,需要检验索引是否合法
                if (index + start < len) {
                    result.append(s.charAt(index + start));
                }
                //添加对称轴左侧字符,需要检验索引是否合法
                if (index + diff - start < len) {
                    result.append(s.charAt(index + diff - start));
                }
                //加间隔移动到下一个子串
                index += diff;
            }
            start++;
        }
        //3.添加对称轴字符
        index = numRows - 1;
        while (index < len) {
            result.append(s.charAt(index));
            index += diff;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(new Convert().convert(s, numRows));
    }
}
