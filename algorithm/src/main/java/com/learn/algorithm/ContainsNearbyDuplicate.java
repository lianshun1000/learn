package com.learn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
       int[] nums = {1,2,3,1};
       int k = 3;
       System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if (k >= i-map.get(nums[i])){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
       return false;
    }
}
