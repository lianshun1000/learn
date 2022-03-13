package com.learn.algorithm.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lianshun
 * @date 2021/7/13 2:52 下午
 * @description 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        //String s = "ababad";
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0)
            return null;
        char[] chars = s.toCharArray();
        int high = 0;
        int low = 0;
        for (int start = 0; start < chars.length; start++) {
            boolean flag = false;
            for (int i = chars.length - 1; i > start; i--) {
                if(flag) break;
                if (chars[i] == chars[start]) {
                    int j = start;
                    int k = i;
                    while (chars[j] == chars[k] && j<=k) {
                        if ((j == k || j == k - 1) && i +1 - start > high - low) {
                            //return s.substring(start, i+1);
                            high = i + 1;
                            low = start;
                            flag = true;
                            break;
                        }
                        j++;
                        k--;
                    }

                }
            }
        }
if(high==0){
    high ++;
}
        return s.substring(low, high);
    }
}
