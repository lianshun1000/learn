package com.learn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    /**
     * 给定⼀个数组，要求在这个数组中找出 4 个数之和为 0 的所有组合。
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);
        final int size = nums.length;

        return null;
    }
}
