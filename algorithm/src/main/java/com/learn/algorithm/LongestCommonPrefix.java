package com.learn.algorithm;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flowllll" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = false;
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == strs[0].charAt(i)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                result.append(String.valueOf(strs[0].charAt(i)));
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }
}
