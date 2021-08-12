package com.learn.algorithm.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lianshun
 * @date 2021/7/12 3:50 下午
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abcabcaa"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    //效率极低
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] arr = s.toCharArray();
        int pointA = 0;
        int pointB = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while (pointB != arr.length) {
            if (!set.contains(arr[pointB])) {
                set.add(arr[pointB]);
                pointB++;
            } else if (set.contains(arr[pointB])) {
                result = result > pointB - pointA ? result : pointB - pointA;
                pointA++;
                pointB = pointA;
                set.clear();
            }
            if (pointB == arr.length - 1 && !set.contains(arr[pointB])) {
                result = result > pointB - pointA + 1 ? result : pointB - pointA + 1;

                break;
            }
        }
        return result;
    }
}
