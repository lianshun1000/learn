package com.learn.algorithm;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    /**
     * 给定⼀个数组，要求在这个数组中找出 4 个数之和为 target 的所有组合。
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        //List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        final int size = nums.length;
        for (int i = 0; i < size - 3; i++) {
            int target2 = target - nums[i];
            for (int j = i + 1; j < size - 2; j++) {
                int baseVal = nums[j];
                int secPr = size - 1;
                int firPr = j + 1;
                while (secPr > firPr) {
                    int comp = target2 - baseVal - nums[firPr] - nums[secPr];
                    if (comp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[firPr]);
                        list.add(nums[secPr]);
                        results.add(list);
                        firPr++;
                    }
                    if (comp < 0) {
                        secPr--;
                    }
                    if (comp > 0) {
                        firPr++;
                    }
                }

            }

        }

        return new ArrayList<>(results);
    }
}
